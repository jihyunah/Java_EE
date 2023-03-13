package user.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor //매개변수 없는 생성자 생성 
@AllArgsConstructor //모든 매개변수 있는 생성자 생성 
@RequiredArgsConstructor //요구되는 매개변수 가져오는 생성자 생

public class UserDTO {
	private String name;
	@NonNull //id의 값을 null값인걸 허용하지 않겠다. --> requiredargsconstructor로 감.
	private String id;
	private String pwd;
	
	
	
	
}
