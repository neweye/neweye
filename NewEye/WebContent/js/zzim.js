   var Cpage; // 현재 페이지 
   var pagingSize = 3; // 원하는 페이지 사이즈로 조정하세용 
   function chkRecent(a) {
      var itemID = getCookie("itemID");
      $("#right_zzim #ul").html(''); // 일단 Ul 내용 지우기... 
      if (itemID) {
         var totcount = itemID.split('&').length - 1; //
         var totpage = Math.ceil(totcount / pagingSize) * 1;
         Cpage = (totpage >= a) ? a : 1;
         Cpage = (Cpage < 1) ? totpage : Cpage;
         var start = (Cpage - 1) * pagingSize;
         for (i = start; i <= start + (pagingSize - 1); i++) {
            var thisItem = itemID.split('&')[i];
            if (thisItem) {
               var itemId = thisItem.split(':')[0];
               var itemImg = thisItem.split(':')[1];
               var itemName = thisItem.split(':')[2];
               $("#right_zzim #ul")
                     .append(
                           '<a href="productDetail.ne?pseq='
                                 + itemId
                                 + '" target="_top"><img src="productimg/'+itemImg+'"  width="100" border=1><div>'
                                 + itemName + '</div> </a><br>')
            }
         }
         $("#paging").show();
      } else {
         $("#right_zzim ul").append(
               '<p class="noData">최근 본 상품이<br> 없습니다.</p>');
         $("#paging").hide();
         $("#recentCnt").text('');
      }
      updateRecentPage(totcount, Cpage);
   }
   chkRecent(1);
   function removeRecentItem(itemname) {
      var itemID = getCookie("itemID");
      itemID = itemID.replace(itemname + "&", "");
      setCookie("itemID", itemID, 1);
      chkRecent(Cpage);
   }
   function updateRecentPage(totcount, Cpage) { //  
      $("#recentCnt").text(totcount); //
      $("#totalPageCount").text("/" + Math.ceil((totcount / pagingSize) * 1));
      if (Math.ceil((totcount / pagingSize) * 1) < Cpage) {
         $("#currentPage").text(Math.ceil((totcount / pagingSize) * 1));
      } else {
         $("#currentPage").text(Cpage); //
      }
   }
   $(".btn_next").on('click', function() {
      chkRecent(Cpage + 1);
   });
   $(".btn_prev").on('click', function() {
      chkRecent(Cpage - 1);
   });
   function getCookie(cookieName) {
      var search = cookieName + "=";
      var cookie = document.cookie;
      // 현재 쿠키가 존재할 경우
      if (cookie.length > 0) {
         // 해당 쿠키명이 존재하는지 검색한 후 존재하면 위치를 리턴.
         startIndex = cookie.indexOf(cookieName);
         // 만약 존재한다면
         if (startIndex != -1) {
            // 값을 얻어내기 위해 시작 인덱스 조절
            startIndex += cookieName.length;
            // 값을 얻어내기 위해 종료 인덱스 추출
            endIndex = cookie.indexOf(";", startIndex);
            // 만약 종료 인덱스를 못찾게 되면 쿠키 전체길이로 설정
            if (endIndex == -1)
               endIndex = cookie.length;
            // 쿠키값을 추출하여 리턴
            return unescape(cookie.substring(startIndex + 1, endIndex));
         } else {
            // 쿠키 내에 해당 쿠키가 존재하지 않을 경우
            return false;
         }
      } else {
         // 쿠키 자체가 없을 경우
         return false;
      }
   }