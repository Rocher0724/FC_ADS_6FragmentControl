# FC_ADS_6 FragmentControl
패스트캠퍼스 안드로이드 스튜디오, 프로젝트 6. Fragment 사용하기

## Activity 내에서 주요 사항

* 생성 : new - fragment - blank - include 체크 2개 해제한 후 finish

* 사용

```

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

    }
}

```

## Fragment.java 내에서 주요 사항

```
public class ListFragment extends Fragment {

    public ListFragment() {
        // 생성자에 어떤것을 입력할 수 없음.
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // 항상 이것을 해주었다. View 를 리턴해야 함
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        return view;
    }

}

```

