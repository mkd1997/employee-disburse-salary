
$(document).ready(
    function(){
        $("#hide").hide();

        /*$("button").click(
            function(){
                let uname = $("#inputID").val();
                let pass= $("#inputPassword").val();
                let url = "http://127.0.0.1:8080/academic_erp_war_exploded/webapi/login";
                let formData = new FormData();
                formData.append('emp_id',uname);
                formData.append('password',pass);
                //$.post( url, { emp_id: uname , password: pass },function(response){
                 //   console.log(response);
                //});
                //$.post( url,formData,function(response){
                 //  console.log(response);
                //});
                $.ajax({
                   url:url,
                   type:'POST',
                   dataType:FormData,
                    data: formData,
                    success:function (res) {
                        console.log(res);
                    }
                });
                //alert(msg);
                $("#hide").show();
                // window.location.replace("http://stackoverflow.com");
                //$.a
            }
        );*/

    }
);
