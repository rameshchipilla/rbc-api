package git.rbc.api.util;

public class RestPreconditions {

	public static <T> T checkFound(T resource) {
		if (resource == null) {
		}
		return resource;
	}

	public static void checkNotNull(Object findById) {
		// TODO Auto-generated method stub

	}

}
