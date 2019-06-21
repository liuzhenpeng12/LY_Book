var html = "";
function main() {
    $.ajax({
        type:"get",
        url: "http://localhost:8181/ebook/allbook?pageNo=1&pageSize=20",
        dataType: "json",
        success: function(data) {
            console.log(data);
            for (var i = 0; i < data.list.length; i++) {
                html += '<div style="    width: 300px;\n' +
                    '    height: 400px;\n' +
                    '    float: left;">'
                html += '<div class="mdui-card" style="    width: 180px;height: 240px;">';
                html += '<img src="'+data.list[i].imgpath+'" /></div>';
                html +='<div class="mdui-card-primary"><div class="mdui-card-primary-title"><a href="allsection.html?bookname='+data.list[i].id+'">'+data.list[i].bookname+'</a></div><div class="mdui-card-primary-subtitle">'+data.list[i].author+'</div></div>';
                html +='</div></div>';

            }
            $('#mian').html(html);
        }
    })
}
main();