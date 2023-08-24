// 0. onclick하면 span -> input tag로 바뀌어야함
const originalSpan1 = $("css-du0zpy");
const originalSpan2 = $();


// 인풋 포커스 이벤트
// $(document).ready(function () {

$(".css-1y9i12j").on("focus, click", function () {
    $(this).attr("placeholder", "");
    $(".card-number").addClass("css-du0zpy");
    $(".card-number").removeClass("addStyle");
});


// 인풋 블러 이벤트
$('.css-1y9i12j').on('blur',function(){
    $(this).attr("placeholder","")
    $('.card-number').addClass('css-du0zpy');
    $('.card-number').removeClass('addStyle');

});






// 0-1. input tag는 클래스이름은 동일, 속성만 추가됨
$("css-1y9i12j").placeholder="14~16자리"
$("css-tbm6v1").placeholder="MM/YY"
$("css-tbm6v1").placeholder="생년월일 6자리 (또는 사업자번호 10자리)"

// 1. 카드번호 4 - 6 - 5 자리 입력될때 자동으로 하이픈 생기게 하기
function inputValidThru(period) {

    // replace 함수를 사용하여 슬래시( / )을 공백으로 치환한다.
    var replaceCard = period.value.replace(/\//g, "");

    // 텍스트박스의 입력값이 4~5글자 사이가 되는 경우에만 실행한다.
    if(replaceCard.length >= 4 && replaceCard.length < 5) {

        var inputMonth = replaceCard.substring(0, 2);    // 선언한 변수 month에 월의 정보값을 담는다.
        var inputYear = replaceCard.substring(2, 4);       // 선언한 변수 year에 년의 정보값을 담는다.


// 2. 유효기간 관련
        // 현재 날짜 값을 구한다.

        var nowDate = new Date();

        var nowMonth = autoLeftPad(nowDate.getMonth() + 1, 2);

        var nowYear = autoLeftPad(nowDate.getFullYear().toString().substr(2, 2), 2);


        // isFinite함수를 사용하여 문자가 선언되었는지 확인한다.
        if(isFinite(inputMonth + inputYear) == false) {
            alert("문자는 입력하실 수 없습니다.");
            period.value = autoLeftPad((Number(nowMonth) + 1), 2) + "/" + nowYear;
            return false;
        }

        // 입력한 월이 12월 보다 큰 경우
        if(inputMonth > 12) {
            alert("12월보다 큰 월수는 입력하실 수 없습니다. ");
            period.value = "12/" + inputYear;
            return false;
        }



        // 입력한 유효기간을 현재날짜와 비교하여 사용 가능 여부를 판단한다.
        if((inputYear + inputMonth) <= (nowYear + nowMonth)) {
            alert("유효기간이 만료된 카드는 사용하실 수 없습니다.");
            period.value = inputMonth + "/" + autoLeftPad((Number(nowYear) + 1), 2);
            return false;
        }

        period.value = inputMonth + "/" + inputYear;
    }
}



// 1자리 문자열의 경우 앞자리에 숫자 0을 자동으로 채워 00형태로 출력하기위한 함수
function autoLeftPad(num, digit) {
    if(String(num).length < digit) {
        num = new Array(digit - String(num).length + 1).join('0') + num;
    }
    return num;
}

// 3. 생년월일(6자리) 또는 사업자번호(10자리)



// 4. 3개의 input value가 모두 다 입력되면 버튼 색상이 오렌지로 바뀜