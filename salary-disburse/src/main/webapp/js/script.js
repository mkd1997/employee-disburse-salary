
$(document).ready(
    function(){
        $("#hide").hide();

        $("button").click(
            function(){
                let uname = $("#inputID").val();
                let pass= $("#inputPassword").val();
                let url = "http://127.0.0.1:8080/salary_disburse_war_exploded/login";

                $.post( url, { emp_id: uname , password: pass } );
                //alert(msg);
                $("#hide").show();
                // window.location.replace("http://stackoverflow.com");
                //$.a
            }
        );

    }
);