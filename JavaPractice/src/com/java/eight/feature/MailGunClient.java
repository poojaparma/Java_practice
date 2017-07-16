package com.java.eight.feature;

public class MailGunClient {
	public String snedMail() {
		String value = null;
		System.out.println("send mail");
		DiamondProblem problem = new DiamondProblem();

		Retry<RetryService<String>, String> example = new Retry<RetryService<String>, String>(3);
		try {
			value = example.retryPolicy(() -> {
				System.out.println("mail gun cleint: " + problem.toString());
				throw new RuntimeException();
				// value="succesfull";

				// return value;
			});

		} catch (Exception e) {
			System.out.println("print value");
		}
		return value;

	}

	public static void main(String[] args) {
		new MailGunClient().snedMail();
		RetryService retryt= new Retry(7);
		retryt.log();
		
	}
}

