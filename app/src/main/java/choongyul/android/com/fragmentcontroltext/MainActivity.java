package choongyul.android.com.fragmentcontroltext;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // 1. 사용할 프래그먼트 선언
    ListFragment list;
    DetailFragment detail;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. 프래그먼트 생성
        list = new ListFragment();
        detail = new DetailFragment();

        // 3. 프래그먼트 매니저 가져오기
        manager = getSupportFragmentManager();
        // 리스트 프래그먼트에 actiity 를 넘겨준다.
        list.setActivity(this);
        detail.setActivity(this);

        setList();

    }

    // Activity에 처음 목록이 세팅될 때
    public void setList() {
        // 1. 프래그먼트를 실행하기 위한 트랜잭션 시작
        FragmentTransaction transaction = manager.beginTransaction();
        // 2. 프래그먼트를 레이아웃에 add 한다.
        transaction.add(R.id.fragment, list);
        // 3. 트랜잭션 전체를 stack에 저장을 한다.
        // 최초에 프래그먼트를 액티비티 위에 쌓게된다. 이걸 주석처리하면 액티비티에 붙어나온다.
//        transaction.addToBackStack(null);
        // 4. git의 commit와 같은 기능
        transaction.commit();

    }

    // 리스트에서 상세로 이동할 때
    public void goDetail() {
        // 1. 프래그먼트를 실행하기 위한 트랜잭션 시작
        FragmentTransaction transaction = manager.beginTransaction();
        // 2. 프래그먼트를 레이아웃에 add 한다.
        transaction.add(R.id.fragment, detail);
        // 3. 트랜잭션 전체를 stack에 저장을 한다.
        transaction.addToBackStack(null);
        // 4. git의 commit와 같은 기능
        transaction.commit();
    }

    // Detail 프래그먼트에서 list로 돌아갈 때 스택을 빼낸다.
    public void backToList() {
        super.onBackPressed();
//        // 1. 프래그먼트를 실행하기 위한 트랜잭션 시작
//        FragmentTransaction transaction = manager.beginTransaction();
//        // 2. detail 프래그먼트를 스택에서 제거한다.
//        transaction.remove(detail);
//        // 3. commit. 커밋을 해야 화면에 반영이된다.
//        transaction.commit();
    }
}
