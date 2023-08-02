let index = {
	init:function(){
		$("#btn-save").on("click",()=>{
			this.save();
		});
		$("#btn-delete").on("click",()=>{
			this.deleteById();
		});
		$("#btn-update").on("click",()=>{
			this.update();
		});
		$("#btn-reply-save").on("click", ()=>{ 
            this.replySave();
        });
		$("#btn-reply-Delete").on("click", ()=>{ 
            this.replyDelete();
        });

	},
	
	save: function(){
		alert('user의 save함수 호출됨');
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
		}
		
		$.ajax({//글쓰기 수행 요청
			type:"post",
			url:"/api/board",
			data:JSON.stringify(data),//http 바디 데이터
			contentType:"application/json; charset=utf-8",//바디데이터가 어떤 타입인지(mime)
			dataType:"json"//요청을 서버로 해서 응답이 왔을땐,기본적으로 모든것이 문자열(생긴게 json이라면)
		}).done(function(resp){
			alert("글쓰기가 완료되었습니다.");
			location.href = "/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});//에이젝스 통신을 이용하여 3개의 파라미터를 제이슨으로 변경하여 인서트 요청
	},

	deleteById: function(){
		let id = $("#id").text();
		$.ajax({
			type:"DELETE",
			url:"/api/board"+id,
			dataType:"json"
		}).done(function(resp){
			alert("삭제가 완료되었습니다.");
			location.href = "/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});//에이젝스 통신을 이용하여 3개의 파라미터를 제이슨으로 변경하여 인서트 요청
	},

	update: function(){
		let id = $("#id").val();
		
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
		}
		
		$.ajax({//글쓰기 수행 요청
			type:"put",
			url:"/api/board/"+id,
			data:JSON.stringify(data),//http 바디 데이터
			contentType:"application/json; charset=utf-8",//바디데이터가 어떤 타입인지(mime)
			dataType:"json"//요청을 서버로 해서 응답이 왔을땐,기본적으로 모든것이 문자열(생긴게 json이라면)
		}).done(function(resp){
			alert("글수정이 완료되었습니다.");
			location.href = "/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});//에이젝스 통신을 이용하여 3개의 파라미터를 제이슨으로 변경하여 인서트 요청
	},
	
	 replySave: function(){
         let data = {
               userId: $("#userid").val(),
               boardId: $("#boardid").val(),
               content: $("#reply-content").val()
         };
         
         $.ajax({ 
            type: "POST",
            url: `/api/board/${data.boardId}/reply`,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
         }).done(function(resp){
            alert("댓글작성이 완료되었습니다.");
            location.href = `/board/${data.boardId}`;
         }).fail(function(error){
            alert(JSON.stringify(error));
         }); 
      },
      
      replyDelete : function(boardId, replyId){
         $.ajax({ 
            type: "DELETE",
            url: `/api/board/${boardId}/reply/${replyId}`,
            dataType: "json"
         }).done(function(resp){
            alert("댓글삭제 성공");
            location.href = `/board/${boardId}`;
         }).fail(function(error){
            alert(JSON.stringify(error));
         }); 
      },

}
index.init();

/**
 * 
 */