package exception;

import org.springframework.http.HttpStatus;

public class ApiRequestException extends RuntimeException {

	private HttpStatus status;
	
	//Constructor
	public ApiRequestException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
	
	public ApiRequestException(String message, Throwable cause, HttpStatus status) {
		super(message, cause);
		this.status = status;
	}
	
	/*********************************************************************************************/
	
	//RunTimeException
	public ApiRequestException(String message) {
		super(message);
	}
	
	public ApiRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	/*********************************************************************************************/
	
	//Getter e Setter
	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
}
