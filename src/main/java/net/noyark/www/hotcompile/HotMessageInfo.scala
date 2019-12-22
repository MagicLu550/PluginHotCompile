package net.noyark.www.hotcompile

object HotMessageInfo {

  var welcome = "欢迎使用MagicLu的热编译加载"

  var about = Array(
    "如何使用这个热编译",
    "首先将热编译的源代码按照",
    "------ classes",
    "------ plugin.yml",
    "的项目格式，放到文件夹里，之后放到plugins/HotCompile下",
    "紧接着，它就可以进行热编译了",
    "您可以通过/hc about false关闭这个提醒"
  )

  def aboutIt()={
    //提示信息
    for (about <- HotMessageInfo.about) {
      HotCompile.getHotCompile.getLogger.info(about)
    }
  }
}