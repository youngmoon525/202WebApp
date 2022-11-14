package com.example.temp_delete;

public class Test {
    //클래스 중괄호 사이 ==> 전부 멤버임
    // 메모리에 올리는 순서
    //앞에 static이 붙었는지 여부를 체크
    //인스턴스 멤버의 특징 : 해당하는 클래스가 인스턴스화 되어야지만 접근이 가능하다.
    int iV1 , iV2;
    void iMethod(){
        sV1 = 1 ;
        sV2 = 2 ;

        int test = 0 ;//이거 밖에서 쓸수잇을까?
    }

    // 인스턴스멤버 3개 만들기.
    // 변수 2 , 메소드1
    static int sV1 , sV2;
    static void sMethod(){
        //iV1 = 10; //? 이거 왜 오류일까? : ??????
        Test test = new Test();
        test.iV1 = 10; //스태틱은 먼저 메모리에 올라가기때문에 일반적으로는 접근이 x
                       //스태틱이 메모리에 올라갈때 인스턴스화해서 가지고가야함.

    }
    // lClass에 있는 모든 멤버를 사용하기.
    // 수단과 방법 상관없음.
    // 왜 이렇게 썼는지 이유까지 쓰면 완.
    // 메소드 내부에서 만든 모든것들은 지역멤버라고 한다. ( 지역밖에서는 사용 x )
    // local <= 지역
    void lMethod(){
        class lClass{
            String lV ;
            void lMethod(){

            }
        }
        lClass lc = new lClass();
        lc.lV = "aa";
        lc.lMethod();
    }

    int lMethod2(){ // return은 모든 내가아는것들이 올수있음. return이필요한이유는
                    //메소드는 메소드가 끝나고 나서 내부에 있는 모든것들을 메모리에서 비움.
                    //따라서 메소드가 실행되고나서 결과를 받고싶다면 반드시 return이 필요하다.
        class lClass{
            int a , b;
        }
        lClass lc = new lClass();
        lc.a = 10;
        lc.b = 20;
        return lc.a + lc.b;
    }



    // 스태틱멤버 3개 만들기
    // 변수 2 , 메소드1

    //MainActivity에서 전부다 호출 사용하기.

    // 멤버<- 내가 알고있는 모든것들은 멤버로 사용가능
    // ↓ 메인액티비티에서 Sub의 모든 멤버 접근해서 사용하기.
    class Sub{//<=
        String sub_v1;
        void subMethod(){

        }
    }

    static class sSub{
        static int subV2;
        static void subMethod2(){

        }
        String subV1;
        void subMethod(){

        }
    }




}
