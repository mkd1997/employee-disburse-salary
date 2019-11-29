function getHTMLRow(id,name,department,salary,paid){
    let row = `
    <tr>
        <td>
            <div class="form-check" style="margin-left:35%;">
                    <input type="checkbox" class="form-check-input" value="">
            </div>
        </td>
        <td>`+ id +`</td>
        <td>`+ name +`</td>
        <td>`+ department +`</td>
        <td>`+ salary +`</td>
        <td>`+ paid +`</td>
        <td>
            <div class="input-group mb-3">
                <input type="text" placeholder=" Enter Amount" style="margin:-5px 0 -20px 20px;">
                <div class="input-group-append" style="margin:-5px 0 -20px 0;">
                    <button class="btn btn-outline-secondary" type="button">Pay</button>
                </div>
            </div>
        </td>
    </tr>
    `;
    return row;
}
function getData(){
    let dummy = [
        {
            emp_id:'MT2019000',
            name:'Vatsal',
            department: 'Student',
            salary: '$100,000',
            paid:'$50,000'
        },
        {
            emp_id:'MT2019060',
            name:'Manav',
            department: 'Student',
            salary: '$100,000',
            paid:'$50,000'
        },
        {
            emp_id:'MT2019035',
            name:'Dhruvin',
            department: 'Student',
            salary: '$100,000',
            paid:'$50,000'
        }
    ];
    return dummy;
    /*let url = "ajax/test.html";
    $.get( url, function( data ) {
        console.log(data);
        //$( ".result" ).html( data );
        //alert( "Load was performed." );
    });*/
}
$(document).ready(function(){
    let url = "ajax/test.html";
    $.get( url, function( data ) {
        console.log(data);
        //$( ".result" ).html( data );
        //alert( "Load was performed." );
    });
    //let data = getHTMLRow("abcd","abcd","abcd","abcd","abcd");
    let htmlData = ``;
    let data = getData();
    //console.log(data);
    for(var i=0;i<data.length;i++){
        //console.log(data[i]);
        let x = data[i];
        //console.log(x.emp_id);
        let id = x.emp_id;
        let name = x.name;
        let dept = x.department;
        let salary = x.salary;
        let paid = x.paid;
        let row = getHTMLRow(id,name,dept,salary,paid);
        htmlData = htmlData + row;
    }
    $("#tableBody").html(htmlData);
});