package hello.datasource;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Getter
@ConfigurationProperties("my.datasource") //my.datasource로 시작되는 키
public class MyDataSourcePropertiesV2 {
//타입에 안전하다.(String,int..)

    private String url;
    private String username;
    private String password;
    private Etc etc;

    //생성자가 2개이상이면 바인딩 시켜줄 생성자 메서드에 @ConstructorBinding을 사용해야함
                                                                  //etc를 찾을 수 없으면 안에 속성값을 전부 null또는 0으로 채운다
    public MyDataSourcePropertiesV2(String url, String username, String password, @DefaultValue Etc etc) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.etc = etc;
    }

    @Getter
    public static class Etc {
        private int maxConnection;
        private Duration timeout;
        private List<String> options = new ArrayList<>();
                                                    //값이 없는경우 DEFAULT를 주입
        public Etc(int maxConnection, Duration timeout, @DefaultValue("DEFAULT") List<String> options) {
            this.maxConnection = maxConnection;
            this.timeout = timeout;
            this.options = options;
        }
    }
}
