package com.java.eight.feature;



/**
 * Generic class providing retry functionality
 * retry logic .Retry interface returns only generic type which will be wrapped
 * into object  and at other end will be type cast to desired object form
 *
 *
 * @param <T>
 */
public class Retry<E extends RetryService<T>, T> implements RetryService<T> {
    int maxRetries = 0;
   // private static final Logger LOGGER = LoggerFactory.getLogger(Retry.class);

    public Retry(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    public T retryPolicy(E impl) {

        T value = null;
        int retryCounter = 0;
        while (retryCounter < maxRetries) {
            try {

                // retry logic
                value = impl.noOfTries();
                break;

            } catch (Exception exception) {
                retryCounter++;
                System.out.println("exceptionoccured while retrying");
                if (retryCounter >= maxRetries) {
                  //  LOGGER.debug("Exception occured while retring");
                    throw new RuntimeException(exception);
                }
            }

        }
        return value;
    }
    @Override
   public void log(){
		System.out.println("logging...........");
	}

	@Override
	public T noOfTries() {
		// TODO Auto-generated method stub
		return null;
	}
}