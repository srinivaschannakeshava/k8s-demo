package in.srini91.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HelloModel {

	private String type;
	private String response;
	private String version;
	private String hostName;
	private String ip;
}
