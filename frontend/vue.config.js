module.exports = {
  devServer: {
    port: 8081,
    proxy: {
      '/api': {
        ws: true,
        changeOrigin: true
      }
    }
  },
  outputDir: 'target/dist',
  assetsDir: 'static'
}
