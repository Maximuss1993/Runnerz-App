package user;

public record User(
		Integer id,
		String name,
		String email,
		AdressOfUser adress,
		String phone,
		String website,
		CompanyOfUser company) {

}
