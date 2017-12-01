/**
 * 接入页面方法
 */  
function reinitIframe(){
                var iframe = document.getElementById("iframeId");
                try{
                    /*获取iframe页面（contentWindowi指ifram对应页面的窗体）窗体的高度 ，document.body.scrollHeight是body元素的滚动高 度*/
                    var bHeight = iframe.contentWindow.document.body.scrollHeight;
                    /*  获取iframe页面，为页面的滚动高度*/
                    var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
                    var height = Math.max(bHeight, dHeight);
                    /*设置页面的高度*/
                    iframe.height = height;            
                }
                catch (ex){

                }
            }
            /*每隔200秒执行一次reint方法*/
            window.setInterval("reinitIframe()", 200);
   