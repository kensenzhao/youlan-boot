
export default {
  props: {
    value: {
      type: String,
      default: null
    },
    files: {
      type: Array,
      default: () => []
    },
    accept: {
      type: String,
      default: null
    },
    action: {
      type: String,
      default: '/system/storage/upload'
    },
    autoUpload: {
      type: Boolean,
      default: false
    },
    disabled: {
      type: Boolean,
      default: false
    },
    headers: {
      type: Object,
      default: () => {
      }
    },
    limit: {
      type: Number,
      default: 1
    },
    platform: {
      type: String,
      default: null
    },
    paramsData: {
      type: Object,
      default: () => {}
    },
    formData: {
      type: Object,
      default: () => {
      }
    },
    fileName: {
      type: String,
      default: 'file'
    },
    // 文件大小限制
    fileSize: {
      type: Number,
      default: 5
    },
    multiple: {
      type: Boolean,
      default: false
    },
    timeout: {
      type: Number,
      default: 60 * 1000
    },
    showTips: {
      type: Boolean,
      default: true
    }
  },
  data() {
    return {
      fileList: []
    }
  },
  watch: {
    value: {
      handler(urls) {
        this.mergeUrls(urls)
      },
      immediate: true,
      deep: true
    }
  },
  mounted() {

  },
  methods: {
    mergeUrls(urls) {
      if (this.$str.isBlank(urls)) {
        this.fileList = []
        return
      }
      this.fileList = urls.split(',').map(url => {
        const file = this.fileList.some(file => file.url === url)
        if (file) {
          return file
        } else {
          return {
            name: url,
            url: url
          }
        }
      })
    },
    // 更新绑定值
    updateValue() {
      this.$emit('input', this.fileList.map(item => item.url).join(','))
    },
    // 删除文件
    removeFile(file) {
      if (!file) {
        return
      }
      this.fileList = this.fileList.filter(item => item.url !== file.url)
      this.updateValue()
    },
    submit() {
      this.$refs.upload && this.$refs.upload.submit()
    },
    clear() {
      this.fileList = []
      this.$refs.upload && this.$refs.upload.clearFiles()
    },
    onRemove(file, fileList) {
      this.fileList = fileList
      this.updateValue()
    },
    onSuccess(response, file, fileList) {
      this.$modal.loadingClose()
      this.fileList = fileList.map(item => {
        // 取完整文件访问地址
        const url = item.response && this.$download.parseSrcUrl(item.response.data.url)
        return {
          ...item,
          url: url || item.url
        }
      })
      this.updateValue()
      this.$emit('onSuccess', response, file, fileList)
    },
    onError(error, file, fileList) {
      this.$modal.loadingClose()
      this.$emit('onError', error, file, fileList)
    },
    onExceed(files, fileList) {
      this.$modal.loadingClose()
      this.$emit('onExceed', files, fileList)
    },
    onPreview(file) { },
    onChange(file, fileList) {
      this.fileList = fileList
      // 非自动提交时需要替代beforeUpload执行校验，校验失败则删除文件
      if (!this.autoUpload && !this.checkFile(file)) {
        this.removeFile(file)
      }
      this.$emit('onChange', file, fileList)
    },
    beforeUpload(file) {
      if (!this.checkFile(file)) {
        this.removeFile(file)
        return false
      }
      this.$modal.loading('正在上传中, 请稍等...')
    },
    httpRequest(context) {
      const { action } = context
      const formData = new FormData()
      formData.append('platform', this.$str.isNotBlank(this.platform) ? this.platform : '')
      formData.append(this.fileName, context.file)
      for (const key in this.formData) {
        formData.append(key, this.formData[key])
      }
      this.$upload.upload(action, formData, this.paramsData, this.headers, { timeout: this.timeout, canRepeatSubmit: true }).then(res => {
        context.onSuccess(res)
      }).catch(error => {
        console.log(error)
        context.onError(error)
      })
    },
    checkFile(file) {
      if (file.size && file.size > this.fileSize * 1024 * 1024) {
        this.$modal.error(`文件上传大小不能超过${this.fileSize}MB`)
        return false
      }
      return true
    }
  }
}
