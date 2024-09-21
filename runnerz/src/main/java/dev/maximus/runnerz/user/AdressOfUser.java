package dev.maximus.runnerz.user;

public record AdressOfUser(
		String street,
		String suite,
		String city,
		String zipcode,
		GeoOfUser geo){

}
