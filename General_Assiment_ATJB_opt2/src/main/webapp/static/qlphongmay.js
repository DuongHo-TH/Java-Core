$("#danhsachmay").click(function() {
	$(".danhsachmay").show();
	$(".danhsachkh").hide();
	$(".danhsachdv").hide();
});

$("#danhsachkh").click(function() {
	$(".danhsachmay").hide();
	$(".danhsachkh").show();
	$(".danhsachdv").hide();
});
$("#danhsachdv").click(function() {
	console.log("anclick");
	$(".danhsachmay").hide();
	$(".danhsachkh").hide();
	$(".danhsachdv").show();
});
$("#all").click(function(){
	$(".danhsachmay").show();
	$(".danhsachkh").show();
	$(".danhsachdv").show();
})
/*$("#buttondelete").click(function(){
	 var  check =  confirm("Bạn có chắc chắn muốn xóa không");
	 if(check){
		 $.ajax({
                url: '${pageContext.request.contextPath}/deletemaytram?mayid=${may.getMamay()}', 
                type: 'GET'
	 }) 
	 }
})*/

function deleteData(id) {
		 var  check =  confirm("Bạn có chắc chắn muốn xóa không");
	 if(check){
		 $.ajax({
                url: 'deletemaytram?mayid=' + id, 
                type: 'GET',
                success: function(request) {
                   
                    }
	 }) 
	 }
}