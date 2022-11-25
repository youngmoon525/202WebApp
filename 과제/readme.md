// 2022 / 11 / 25
    // Android Project # 1
    // Feeback : 공통
    // 텍스트뷰 , 버튼 등 반복 되는 위젯들은 하나로 묶어서 사용하는게 좋음.
    // 하나로 묶어서 사용하면 ArrayList나 기타 Collection자료 구조로
    //이벤트연결 부분이나 반복되는 코드를 줄일수있음.
    
    // 코드가 반복되는 구간은 메소드로 처리하면 좋음 공통으로 대부분 onClick이벤트
    // 음료 주문버튼 클릭하고 나서 코드가 4번 반복됨.=> 하나의 메소드로 만드는게 좋음


    // A조 => btn_c같은 이름은 사용하면 나중에 가독성이 떨어짐 (안좋은습관)
    
    // B조
    // HashMap을 사용한 부분이 인상적임(잘함)

    // C조 
    // ResultDTO , MoneyDTO는 별도로 만들필요없음
    // MoneyDTO<= int값 하나인데 객체 타입사용==> 메모리낭비
    // 예시 ↓
//    public class WidgetDTO{
//        private TextView tv_name , tv_price;
//        private Button btn_order ;
//
//        public WidgetDTO(TextView tv_name, TextView tv_price, Button btn_order) {
//            this.tv_name = tv_name;
//            this.tv_price = tv_price;
//            this.btn_order = btn_order;
//        }
//
//        public TextView getTv_name() {
//            return tv_name;
//        }
//
//        public void setTv_name(TextView tv_name) {
//            this.tv_name = tv_name;
//        }
//
//        public TextView getTv_price() {
//            return tv_price;
//        }
//
//        public void setTv_price(TextView tv_price) {
//            this.tv_price = tv_price;
//        }
//
//        public Button getBtn_order() {
//            return btn_order;
//        }
//
//        public void setBtn_order(Button btn_order) {
//            this.btn_order = btn_order;
//        }
//    }
//