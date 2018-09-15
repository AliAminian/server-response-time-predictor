package predictor;

import java.sql.Date;
import java.text.ParseException;

import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.linalg.Vectors;
import org.apache.spark.mllib.regression.LabeledPoint;


public class ServiceModel {

	private final Long calleeService;
	private final Date serviceCallingDate;
	private final Long serviceDelay;
	private final Long responseCode;
	private final Long amount_service_parameter;
	private final Long callerService;



	public ServiceModel(Long calleeService, Date inputTime, Long serviceDelay, Long responseCode, Long amount_service_parameter, Long callerService) {
		super();
		this.calleeService = calleeService;
		this.serviceCallingDate = inputTime;
		this.serviceDelay = serviceDelay;
		this.responseCode = responseCode;
		this.amount_service_parameter = amount_service_parameter;
		this.callerService = callerService;

	}

	public ServiceModel(String... row) {
		this(Long.parseLong(row[0]), new Date(parseDate(row[1])), Long.parseLong(row[2]), Long.parseLong(row[3]),
				Long.parseLong(row[4]), Long.parseLong(row[5]));
	}

	public LabeledPoint toLabeledPoint() {
		return new LabeledPoint(label(), features());
	}

	public double label() {
		return serviceDelay;
	}

	public Vector features() {
		double[] features = {calleeService, responseCode, amount_service_parameter, callerService};
		return Vectors.dense(features);
	}

	static Long parseDate(String value) {
		try {
			return new java.text.SimpleDateFormat("yyyyMMdd'T'hhmmss").parse(value).getTime();
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public Long getCalleeService() {
		return calleeService;
	}

	public Date getServiceCallingDate() {
		return serviceCallingDate;
	}

	public Long getServiceDelay() {
		return serviceDelay;
	}

	public Long getResponseCode() {
		return responseCode;
	}

	public Long getAmount_service_parameter() {
		return amount_service_parameter;
	}

	public Long getCallerService() {
		return callerService;
	}

}