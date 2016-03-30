$(function () {
  $(".xj_uploader_input").click(function() {
    //触发文件选择控件
    $("input[forinput='"+$.trim(this.id)+"']").click();
    //清空输入框中内容
    $(this).val("");
  });
  
  $('.file_uploader').fileupload({
    dataType: 'json',
    
    done: function (e, data) {
      var obj = $("#"+$(this).attr('forinput'));
      if($.trim($(obj).val()) == "") {
        $(obj).val(data.result);
      } else {
        $(obj).val($(obj).val() + "|" + data.result);
      }
    },
    
    progressall: function (e, data) {
//      var progress = parseInt(data.loaded / data.total * 100, 10);
//      $('#progress .bar').css(
//          'width',
//          progress + '%'
//      );
    },
   
    dropZone: $('#dropzone')
  });
});