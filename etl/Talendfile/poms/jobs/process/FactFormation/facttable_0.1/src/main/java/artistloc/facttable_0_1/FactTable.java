
package artistloc.facttable_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.SQLike;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;
 





@SuppressWarnings("unused")

/**
 * Job: FactTable Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status DEV
 */
public class FactTable implements TalendJob {
	static {System.setProperty("TalendJob.log", "FactTable.log");}

	

	
	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(FactTable.class);
	

protected static void logIgnoredError(String message, Throwable cause) {
       log.error(message, cause);

}


	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	
	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	
	private final static String utf8Charset = "UTF-8";
	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
		}
	
		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}
	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "FactTable";
	private final String projectName = "ARTISTLOC";
	public Integer errorCode = null;
	private String currentComponent = "";
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName, "_fmjDgJ-AEe-WU-XkN6_jvg", "0.1");
private org.talend.job.audit.JobAuditLogger auditLogger_talendJobLog = null;

private RunStat runStat = new RunStat(talendJobLog, System.getProperty("audit.interval"));

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
                    dataSources.put(entry.getKey(), entry.getValue());
                    talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}


private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

public String getExceptionStackTrace() {
	if ("failure".equals(this.getStatus())) {
		errorMessagePS.flush();
		return baos.toString();
	}
	return null;
}

private Exception exception;

public Exception getException() {
	if ("failure".equals(this.getStatus())) {
		return this.exception;
	}
	return null;
}

private class TalendException extends Exception {

	private static final long serialVersionUID = 1L;

	private java.util.Map<String, Object> globalMap = null;
	private Exception e = null;
	private String currentComponent = null;
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
        Throwable cause = e;
        String message = null;
        int i = 10;
        while (null != cause && 0 < i--) {
            message = cause.getMessage();
            if (null == message) {
                cause = cause.getCause();
            } else {
                break;          
            }
        }
        if (null == message) {
            message = e.getClass().getName();
        }   
        return message;
    }

	@Override
	public void printStackTrace() {
		if (!(e instanceof TalendException || e instanceof TDieException)) {
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				FactTable.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(FactTable.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
			}
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tDBConnection_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBConnection_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBCommit_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBCommit_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_7_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_8_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row7_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row8_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void talendJobLog_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					talendJobLog_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBConnection_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBCommit_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void talendJobLog_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	


public void tDBConnection_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBConnection_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tDBConnection_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBConnection_2", false);
		start_Hash.put("tDBConnection_2", System.currentTimeMillis());
		
	
	currentComponent="tDBConnection_2";

	
		int tos_count_tDBConnection_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBConnection_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBConnection_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBConnection_2 = new StringBuilder();
                    log4jParamters_tDBConnection_2.append("Parameters:");
                            log4jParamters_tDBConnection_2.append("DB_VERSION" + " = " + "V9_X");
                        log4jParamters_tDBConnection_2.append(" | ");
                            log4jParamters_tDBConnection_2.append("HOST" + " = " + "\"localhost\"");
                        log4jParamters_tDBConnection_2.append(" | ");
                            log4jParamters_tDBConnection_2.append("PORT" + " = " + "\"5432\"");
                        log4jParamters_tDBConnection_2.append(" | ");
                            log4jParamters_tDBConnection_2.append("DBNAME" + " = " + "\"MusicDW\"");
                        log4jParamters_tDBConnection_2.append(" | ");
                            log4jParamters_tDBConnection_2.append("SCHEMA_DB" + " = " + "\"\"");
                        log4jParamters_tDBConnection_2.append(" | ");
                            log4jParamters_tDBConnection_2.append("USER" + " = " + "\"postgres\"");
                        log4jParamters_tDBConnection_2.append(" | ");
                            log4jParamters_tDBConnection_2.append("PASS" + " = " + String.valueOf("enc:routine.encryption.key.v1:9dSFCt8HA5zOXZFpWL2YXHAyZM7v+kpiN6yxeJudbrOh").substring(0, 4) + "...");     
                        log4jParamters_tDBConnection_2.append(" | ");
                            log4jParamters_tDBConnection_2.append("USE_SHARED_CONNECTION" + " = " + "true");
                        log4jParamters_tDBConnection_2.append(" | ");
                            log4jParamters_tDBConnection_2.append("SHARED_CONNECTION_NAME" + " = " + "\"trgtConn\"");
                        log4jParamters_tDBConnection_2.append(" | ");
                            log4jParamters_tDBConnection_2.append("PROPERTIES" + " = " + "\"\"");
                        log4jParamters_tDBConnection_2.append(" | ");
                            log4jParamters_tDBConnection_2.append("AUTO_COMMIT" + " = " + "false");
                        log4jParamters_tDBConnection_2.append(" | ");
                            log4jParamters_tDBConnection_2.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlConnection");
                        log4jParamters_tDBConnection_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBConnection_2 - "  + (log4jParamters_tDBConnection_2) );
                    } 
                } 
            new BytesLimit65535_tDBConnection_2().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBConnection_2", "trgtConn", "tPostgresqlConnection");
				talendJobLogProcess(globalMap);
			}
			


	
            String dbProperties_tDBConnection_2 = "";
            String url_tDBConnection_2 = "jdbc:postgresql://"+"localhost"+":"+"5432"+"/"+"MusicDW";
            
            if(dbProperties_tDBConnection_2 != null && !"".equals(dbProperties_tDBConnection_2.trim())) {
                url_tDBConnection_2 = url_tDBConnection_2 + "?" + dbProperties_tDBConnection_2;
            }
	String dbUser_tDBConnection_2 = "postgres";
	
	
		 
	final String decryptedPassword_tDBConnection_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:7kGCaYi6qDrwi/YFNfKMoXvdm5Cz856boOhSnWKuz4WX");
		String dbPwd_tDBConnection_2 = decryptedPassword_tDBConnection_2;
	
	
	java.sql.Connection conn_tDBConnection_2 = null;
	
        java.util.Enumeration<java.sql.Driver> drivers_tDBConnection_2 =  java.sql.DriverManager.getDrivers();
        java.util.Set<String> redShiftDriverNames_tDBConnection_2 = new java.util.HashSet<String>(java.util.Arrays
                .asList("com.amazon.redshift.jdbc.Driver","com.amazon.redshift.jdbc41.Driver","com.amazon.redshift.jdbc42.Driver"));
    while (drivers_tDBConnection_2.hasMoreElements()) {
        java.sql.Driver d_tDBConnection_2 = drivers_tDBConnection_2.nextElement();
        if (redShiftDriverNames_tDBConnection_2.contains(d_tDBConnection_2.getClass().getName())) {
            try {
                java.sql.DriverManager.deregisterDriver(d_tDBConnection_2);
                java.sql.DriverManager.registerDriver(d_tDBConnection_2);
            } catch (java.lang.Exception e_tDBConnection_2) {
globalMap.put("tDBConnection_2_ERROR_MESSAGE",e_tDBConnection_2.getMessage());
                    //do nothing
            }
        }
    }
	
			SharedDBConnectionLog4j.initLogger(log.getName(),"tDBConnection_2");
			String sharedConnectionName_tDBConnection_2 = "trgtConn";
			conn_tDBConnection_2 = SharedDBConnectionLog4j.getDBConnection("org.postgresql.Driver",url_tDBConnection_2,dbUser_tDBConnection_2 , dbPwd_tDBConnection_2 , sharedConnectionName_tDBConnection_2);
			globalMap.put("conn_tDBConnection_2", conn_tDBConnection_2);
	if (null != conn_tDBConnection_2) {
		
			log.debug("tDBConnection_2 - Connection is set auto commit to 'false'.");
			conn_tDBConnection_2.setAutoCommit(false);
	}

	globalMap.put("schema_" + "tDBConnection_2","");

 



/**
 * [tDBConnection_2 begin ] stop
 */
	
	/**
	 * [tDBConnection_2 main ] start
	 */

	

	
	
	currentComponent="tDBConnection_2";

	

 


	tos_count_tDBConnection_2++;

/**
 * [tDBConnection_2 main ] stop
 */
	
	/**
	 * [tDBConnection_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBConnection_2";

	

 



/**
 * [tDBConnection_2 process_data_begin ] stop
 */
	
	/**
	 * [tDBConnection_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBConnection_2";

	

 



/**
 * [tDBConnection_2 process_data_end ] stop
 */
	
	/**
	 * [tDBConnection_2 end ] start
	 */

	

	
	
	currentComponent="tDBConnection_2";

	

 
                if(log.isDebugEnabled())
            log.debug("tDBConnection_2 - "  + ("Done.") );

ok_Hash.put("tDBConnection_2", true);
end_Hash.put("tDBConnection_2", System.currentTimeMillis());




/**
 * [tDBConnection_2 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tDBConnection_2:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk2", 0, "ok");
								} 
							
							tDBInput_1Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBConnection_2 finally ] start
	 */

	

	
	
	currentComponent="tDBConnection_2";

	

 



/**
 * [tDBConnection_2 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBConnection_2_SUBPROCESS_STATE", 1);
	}
	


public static class Found1Struct implements routines.system.IPersistableRow<Found1Struct> {
    final static byte[] commonByteArrayLock_ARTISTLOC_FactTable = new byte[0];
    static byte[] commonByteArray_ARTISTLOC_FactTable = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int listening_activity_key;

				public int getListening_activity_key () {
					return this.listening_activity_key;
				}
				
			    public int user_key;

				public int getUser_key () {
					return this.user_key;
				}
				
			    public int session_key;

				public int getSession_key () {
					return this.session_key;
				}
				
			    public int artist_key;

				public int getArtist_key () {
					return this.artist_key;
				}
				
			    public int song_key;

				public int getSong_key () {
					return this.song_key;
				}
				
			    public BigDecimal total_sesssion_duration;

				public BigDecimal getTotal_sesssion_duration () {
					return this.total_sesssion_duration;
				}
				
			    public int subscription_type;

				public int getSubscription_type () {
					return this.subscription_type;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.listening_activity_key;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final Found1Struct other = (Found1Struct) obj;
		
						if (this.listening_activity_key != other.listening_activity_key)
							return false;
					

		return true;
    }

	public void copyDataTo(Found1Struct other) {

		other.listening_activity_key = this.listening_activity_key;
	            other.user_key = this.user_key;
	            other.session_key = this.session_key;
	            other.artist_key = this.artist_key;
	            other.song_key = this.song_key;
	            other.total_sesssion_duration = this.total_sesssion_duration;
	            other.subscription_type = this.subscription_type;
	            
	}

	public void copyKeysDataTo(Found1Struct other) {

		other.listening_activity_key = this.listening_activity_key;
	            	
	}




    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ARTISTLOC_FactTable) {

        	try {

        		int length = 0;
		
			        this.listening_activity_key = dis.readInt();
					
			        this.user_key = dis.readInt();
					
			        this.session_key = dis.readInt();
					
			        this.artist_key = dis.readInt();
					
			        this.song_key = dis.readInt();
					
						this.total_sesssion_duration = (BigDecimal) dis.readObject();
					
			        this.subscription_type = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ARTISTLOC_FactTable) {

        	try {

        		int length = 0;
		
			        this.listening_activity_key = dis.readInt();
					
			        this.user_key = dis.readInt();
					
			        this.session_key = dis.readInt();
					
			        this.artist_key = dis.readInt();
					
			        this.song_key = dis.readInt();
					
						this.total_sesssion_duration = (BigDecimal) dis.readObject();
					
			        this.subscription_type = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.listening_activity_key);
					
					// int
				
		            	dos.writeInt(this.user_key);
					
					// int
				
		            	dos.writeInt(this.session_key);
					
					// int
				
		            	dos.writeInt(this.artist_key);
					
					// int
				
		            	dos.writeInt(this.song_key);
					
					// BigDecimal
				
       			    	dos.writeObject(this.total_sesssion_duration);
					
					// int
				
		            	dos.writeInt(this.subscription_type);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.listening_activity_key);
					
					// int
				
		            	dos.writeInt(this.user_key);
					
					// int
				
		            	dos.writeInt(this.session_key);
					
					// int
				
		            	dos.writeInt(this.artist_key);
					
					// int
				
		            	dos.writeInt(this.song_key);
					
					// BigDecimal
				
       			    	dos.writeObject(this.total_sesssion_duration);
					
					// int
				
		            	dos.writeInt(this.subscription_type);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("listening_activity_key="+String.valueOf(listening_activity_key));
		sb.append(",user_key="+String.valueOf(user_key));
		sb.append(",session_key="+String.valueOf(session_key));
		sb.append(",artist_key="+String.valueOf(artist_key));
		sb.append(",song_key="+String.valueOf(song_key));
		sb.append(",total_sesssion_duration="+String.valueOf(total_sesssion_duration));
		sb.append(",subscription_type="+String.valueOf(subscription_type));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				sb.append(listening_activity_key);
        			
        			sb.append("|");
        		
        				sb.append(user_key);
        			
        			sb.append("|");
        		
        				sb.append(session_key);
        			
        			sb.append("|");
        		
        				sb.append(artist_key);
        			
        			sb.append("|");
        		
        				sb.append(song_key);
        			
        			sb.append("|");
        		
        				if(total_sesssion_duration == null){
        					sb.append("<null>");
        				}else{
            				sb.append(total_sesssion_duration);
            			}
            		
        			sb.append("|");
        		
        				sb.append(subscription_type);
        			
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(Found1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.listening_activity_key, other.listening_activity_key);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class NotFound1Struct implements routines.system.IPersistableRow<NotFound1Struct> {
    final static byte[] commonByteArrayLock_ARTISTLOC_FactTable = new byte[0];
    static byte[] commonByteArray_ARTISTLOC_FactTable = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int listening_activity_key;

				public int getListening_activity_key () {
					return this.listening_activity_key;
				}
				
			    public int user_key;

				public int getUser_key () {
					return this.user_key;
				}
				
			    public int session_key;

				public int getSession_key () {
					return this.session_key;
				}
				
			    public int artist_key;

				public int getArtist_key () {
					return this.artist_key;
				}
				
			    public int song_key;

				public int getSong_key () {
					return this.song_key;
				}
				
			    public BigDecimal total_sesssion_duration;

				public BigDecimal getTotal_sesssion_duration () {
					return this.total_sesssion_duration;
				}
				
			    public int subscription_type;

				public int getSubscription_type () {
					return this.subscription_type;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.listening_activity_key;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final NotFound1Struct other = (NotFound1Struct) obj;
		
						if (this.listening_activity_key != other.listening_activity_key)
							return false;
					

		return true;
    }

	public void copyDataTo(NotFound1Struct other) {

		other.listening_activity_key = this.listening_activity_key;
	            other.user_key = this.user_key;
	            other.session_key = this.session_key;
	            other.artist_key = this.artist_key;
	            other.song_key = this.song_key;
	            other.total_sesssion_duration = this.total_sesssion_duration;
	            other.subscription_type = this.subscription_type;
	            
	}

	public void copyKeysDataTo(NotFound1Struct other) {

		other.listening_activity_key = this.listening_activity_key;
	            	
	}




    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ARTISTLOC_FactTable) {

        	try {

        		int length = 0;
		
			        this.listening_activity_key = dis.readInt();
					
			        this.user_key = dis.readInt();
					
			        this.session_key = dis.readInt();
					
			        this.artist_key = dis.readInt();
					
			        this.song_key = dis.readInt();
					
						this.total_sesssion_duration = (BigDecimal) dis.readObject();
					
			        this.subscription_type = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ARTISTLOC_FactTable) {

        	try {

        		int length = 0;
		
			        this.listening_activity_key = dis.readInt();
					
			        this.user_key = dis.readInt();
					
			        this.session_key = dis.readInt();
					
			        this.artist_key = dis.readInt();
					
			        this.song_key = dis.readInt();
					
						this.total_sesssion_duration = (BigDecimal) dis.readObject();
					
			        this.subscription_type = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.listening_activity_key);
					
					// int
				
		            	dos.writeInt(this.user_key);
					
					// int
				
		            	dos.writeInt(this.session_key);
					
					// int
				
		            	dos.writeInt(this.artist_key);
					
					// int
				
		            	dos.writeInt(this.song_key);
					
					// BigDecimal
				
       			    	dos.writeObject(this.total_sesssion_duration);
					
					// int
				
		            	dos.writeInt(this.subscription_type);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.listening_activity_key);
					
					// int
				
		            	dos.writeInt(this.user_key);
					
					// int
				
		            	dos.writeInt(this.session_key);
					
					// int
				
		            	dos.writeInt(this.artist_key);
					
					// int
				
		            	dos.writeInt(this.song_key);
					
					// BigDecimal
				
       			    	dos.writeObject(this.total_sesssion_duration);
					
					// int
				
		            	dos.writeInt(this.subscription_type);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("listening_activity_key="+String.valueOf(listening_activity_key));
		sb.append(",user_key="+String.valueOf(user_key));
		sb.append(",session_key="+String.valueOf(session_key));
		sb.append(",artist_key="+String.valueOf(artist_key));
		sb.append(",song_key="+String.valueOf(song_key));
		sb.append(",total_sesssion_duration="+String.valueOf(total_sesssion_duration));
		sb.append(",subscription_type="+String.valueOf(subscription_type));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				sb.append(listening_activity_key);
        			
        			sb.append("|");
        		
        				sb.append(user_key);
        			
        			sb.append("|");
        		
        				sb.append(session_key);
        			
        			sb.append("|");
        		
        				sb.append(artist_key);
        			
        			sb.append("|");
        		
        				sb.append(song_key);
        			
        			sb.append("|");
        		
        				if(total_sesssion_duration == null){
        					sb.append("<null>");
        				}else{
            				sb.append(total_sesssion_duration);
            			}
            		
        			sb.append("|");
        		
        				sb.append(subscription_type);
        			
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(NotFound1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.listening_activity_key, other.listening_activity_key);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_ARTISTLOC_FactTable = new byte[0];
    static byte[] commonByteArray_ARTISTLOC_FactTable = new byte[0];

	
			    public int sessionkey;

				public int getSessionkey () {
					return this.sessionkey;
				}
				
			    public String session_id;

				public String getSession_id () {
					return this.session_id;
				}
				
			    public int userkey;

				public int getUserkey () {
					return this.userkey;
				}
				
			    public int songkey;

				public int getSongkey () {
					return this.songkey;
				}
				
			    public BigDecimal session_duration;

				public BigDecimal getSession_duration () {
					return this.session_duration;
				}
				
			    public int timekey;

				public int getTimekey () {
					return this.timekey;
				}
				
			    public int datekey;

				public int getDatekey () {
					return this.datekey;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ARTISTLOC_FactTable.length) {
				if(length < 1024 && commonByteArray_ARTISTLOC_FactTable.length == 0) {
   					commonByteArray_ARTISTLOC_FactTable = new byte[1024];
				} else {
   					commonByteArray_ARTISTLOC_FactTable = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ARTISTLOC_FactTable, 0, length);
			strReturn = new String(commonByteArray_ARTISTLOC_FactTable, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ARTISTLOC_FactTable.length) {
				if(length < 1024 && commonByteArray_ARTISTLOC_FactTable.length == 0) {
   					commonByteArray_ARTISTLOC_FactTable = new byte[1024];
				} else {
   					commonByteArray_ARTISTLOC_FactTable = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ARTISTLOC_FactTable, 0, length);
			strReturn = new String(commonByteArray_ARTISTLOC_FactTable, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ARTISTLOC_FactTable) {

        	try {

        		int length = 0;
		
			        this.sessionkey = dis.readInt();
					
					this.session_id = readString(dis);
					
			        this.userkey = dis.readInt();
					
			        this.songkey = dis.readInt();
					
						this.session_duration = (BigDecimal) dis.readObject();
					
			        this.timekey = dis.readInt();
					
			        this.datekey = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ARTISTLOC_FactTable) {

        	try {

        		int length = 0;
		
			        this.sessionkey = dis.readInt();
					
					this.session_id = readString(dis);
					
			        this.userkey = dis.readInt();
					
			        this.songkey = dis.readInt();
					
						this.session_duration = (BigDecimal) dis.readObject();
					
			        this.timekey = dis.readInt();
					
			        this.datekey = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.sessionkey);
					
					// String
				
						writeString(this.session_id,dos);
					
					// int
				
		            	dos.writeInt(this.userkey);
					
					// int
				
		            	dos.writeInt(this.songkey);
					
					// BigDecimal
				
       			    	dos.writeObject(this.session_duration);
					
					// int
				
		            	dos.writeInt(this.timekey);
					
					// int
				
		            	dos.writeInt(this.datekey);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.sessionkey);
					
					// String
				
						writeString(this.session_id,dos);
					
					// int
				
		            	dos.writeInt(this.userkey);
					
					// int
				
		            	dos.writeInt(this.songkey);
					
					// BigDecimal
				
       			    	dos.writeObject(this.session_duration);
					
					// int
				
		            	dos.writeInt(this.timekey);
					
					// int
				
		            	dos.writeInt(this.datekey);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("sessionkey="+String.valueOf(sessionkey));
		sb.append(",session_id="+session_id);
		sb.append(",userkey="+String.valueOf(userkey));
		sb.append(",songkey="+String.valueOf(songkey));
		sb.append(",session_duration="+String.valueOf(session_duration));
		sb.append(",timekey="+String.valueOf(timekey));
		sb.append(",datekey="+String.valueOf(datekey));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				sb.append(sessionkey);
        			
        			sb.append("|");
        		
        				if(session_id == null){
        					sb.append("<null>");
        				}else{
            				sb.append(session_id);
            			}
            		
        			sb.append("|");
        		
        				sb.append(userkey);
        			
        			sb.append("|");
        		
        				sb.append(songkey);
        			
        			sb.append("|");
        		
        				if(session_duration == null){
        					sb.append("<null>");
        				}else{
            				sb.append(session_duration);
            			}
            		
        			sb.append("|");
        		
        				sb.append(timekey);
        			
        			sb.append("|");
        		
        				sb.append(datekey);
        			
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class after_tDBInput_1Struct implements routines.system.IPersistableRow<after_tDBInput_1Struct> {
    final static byte[] commonByteArrayLock_ARTISTLOC_FactTable = new byte[0];
    static byte[] commonByteArray_ARTISTLOC_FactTable = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int sessionkey;

				public int getSessionkey () {
					return this.sessionkey;
				}
				
			    public String session_id;

				public String getSession_id () {
					return this.session_id;
				}
				
			    public int userkey;

				public int getUserkey () {
					return this.userkey;
				}
				
			    public int songkey;

				public int getSongkey () {
					return this.songkey;
				}
				
			    public BigDecimal session_duration;

				public BigDecimal getSession_duration () {
					return this.session_duration;
				}
				
			    public int timekey;

				public int getTimekey () {
					return this.timekey;
				}
				
			    public int datekey;

				public int getDatekey () {
					return this.datekey;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.sessionkey;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final after_tDBInput_1Struct other = (after_tDBInput_1Struct) obj;
		
						if (this.sessionkey != other.sessionkey)
							return false;
					

		return true;
    }

	public void copyDataTo(after_tDBInput_1Struct other) {

		other.sessionkey = this.sessionkey;
	            other.session_id = this.session_id;
	            other.userkey = this.userkey;
	            other.songkey = this.songkey;
	            other.session_duration = this.session_duration;
	            other.timekey = this.timekey;
	            other.datekey = this.datekey;
	            
	}

	public void copyKeysDataTo(after_tDBInput_1Struct other) {

		other.sessionkey = this.sessionkey;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ARTISTLOC_FactTable.length) {
				if(length < 1024 && commonByteArray_ARTISTLOC_FactTable.length == 0) {
   					commonByteArray_ARTISTLOC_FactTable = new byte[1024];
				} else {
   					commonByteArray_ARTISTLOC_FactTable = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ARTISTLOC_FactTable, 0, length);
			strReturn = new String(commonByteArray_ARTISTLOC_FactTable, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ARTISTLOC_FactTable.length) {
				if(length < 1024 && commonByteArray_ARTISTLOC_FactTable.length == 0) {
   					commonByteArray_ARTISTLOC_FactTable = new byte[1024];
				} else {
   					commonByteArray_ARTISTLOC_FactTable = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ARTISTLOC_FactTable, 0, length);
			strReturn = new String(commonByteArray_ARTISTLOC_FactTable, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ARTISTLOC_FactTable) {

        	try {

        		int length = 0;
		
			        this.sessionkey = dis.readInt();
					
					this.session_id = readString(dis);
					
			        this.userkey = dis.readInt();
					
			        this.songkey = dis.readInt();
					
						this.session_duration = (BigDecimal) dis.readObject();
					
			        this.timekey = dis.readInt();
					
			        this.datekey = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ARTISTLOC_FactTable) {

        	try {

        		int length = 0;
		
			        this.sessionkey = dis.readInt();
					
					this.session_id = readString(dis);
					
			        this.userkey = dis.readInt();
					
			        this.songkey = dis.readInt();
					
						this.session_duration = (BigDecimal) dis.readObject();
					
			        this.timekey = dis.readInt();
					
			        this.datekey = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.sessionkey);
					
					// String
				
						writeString(this.session_id,dos);
					
					// int
				
		            	dos.writeInt(this.userkey);
					
					// int
				
		            	dos.writeInt(this.songkey);
					
					// BigDecimal
				
       			    	dos.writeObject(this.session_duration);
					
					// int
				
		            	dos.writeInt(this.timekey);
					
					// int
				
		            	dos.writeInt(this.datekey);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.sessionkey);
					
					// String
				
						writeString(this.session_id,dos);
					
					// int
				
		            	dos.writeInt(this.userkey);
					
					// int
				
		            	dos.writeInt(this.songkey);
					
					// BigDecimal
				
       			    	dos.writeObject(this.session_duration);
					
					// int
				
		            	dos.writeInt(this.timekey);
					
					// int
				
		            	dos.writeInt(this.datekey);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("sessionkey="+String.valueOf(sessionkey));
		sb.append(",session_id="+session_id);
		sb.append(",userkey="+String.valueOf(userkey));
		sb.append(",songkey="+String.valueOf(songkey));
		sb.append(",session_duration="+String.valueOf(session_duration));
		sb.append(",timekey="+String.valueOf(timekey));
		sb.append(",datekey="+String.valueOf(datekey));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				sb.append(sessionkey);
        			
        			sb.append("|");
        		
        				if(session_id == null){
        					sb.append("<null>");
        				}else{
            				sb.append(session_id);
            			}
            		
        			sb.append("|");
        		
        				sb.append(userkey);
        			
        			sb.append("|");
        		
        				sb.append(songkey);
        			
        			sb.append("|");
        		
        				if(session_duration == null){
        					sb.append("<null>");
        				}else{
            				sb.append(session_duration);
            			}
            		
        			sb.append("|");
        		
        				sb.append(timekey);
        			
        			sb.append("|");
        		
        				sb.append(datekey);
        			
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(after_tDBInput_1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.sessionkey, other.sessionkey);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;


		tDBInput_4Process(globalMap);
		tDBInput_7Process(globalMap);
		tDBInput_2Process(globalMap);
		tDBInput_8Process(globalMap);

		row1Struct row1 = new row1Struct();
Found1Struct Found1 = new Found1Struct();
NotFound1Struct NotFound1 = new NotFound1Struct();





	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";

	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"Found1");
			
		int tos_count_tDBOutput_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBOutput_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBOutput_1 = new StringBuilder();
                    log4jParamters_tDBOutput_1.append("Parameters:");
                            log4jParamters_tDBOutput_1.append("USE_EXISTING_CONNECTION" + " = " + "true");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("CONNECTION" + " = " + "tDBConnection_2");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("TABLE" + " = " + "\"listening_activity\"");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("TABLE_ACTION" + " = " + "NONE");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("DATA_ACTION" + " = " + "UPDATE");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("DIE_ON_ERROR" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("USE_ALTERNATE_SCHEMA" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("ADD_COLS" + " = " + "[]");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("USE_FIELD_OPTIONS" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("ENABLE_DEBUG_MODE" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("SUPPORT_NULL_WHERE" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("CONVERT_COLUMN_TABLE_TO_LOWERCASE" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("USE_BATCH_SIZE" + " = " + "true");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("BATCH_SIZE" + " = " + "10000");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlOutput");
                        log4jParamters_tDBOutput_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + (log4jParamters_tDBOutput_1) );
                    } 
                } 
            new BytesLimit65535_tDBOutput_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBOutput_1", "__TABLE__", "tPostgresqlOutput");
				talendJobLogProcess(globalMap);
			}
			





String dbschema_tDBOutput_1 = null;
	dbschema_tDBOutput_1 = (String)globalMap.get("schema_" + "tDBConnection_2");
	

String tableName_tDBOutput_1 = null;
if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
	tableName_tDBOutput_1 = ("listening_activity");
} else {
	tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "\".\"" + ("listening_activity");
}

        int updateKeyCount_tDBOutput_1 = 1;
        if(updateKeyCount_tDBOutput_1 < 1) {
            throw new RuntimeException("For update, Schema must have a key");
        } else if (updateKeyCount_tDBOutput_1 == 7 && true) {        
                throw new RuntimeException("For update, every Schema column can not be a key");
        }

int nb_line_tDBOutput_1 = 0;
int nb_line_update_tDBOutput_1 = 0;
int nb_line_inserted_tDBOutput_1 = 0;
int nb_line_deleted_tDBOutput_1 = 0;
int nb_line_rejected_tDBOutput_1 = 0;

int deletedCount_tDBOutput_1=0;
int updatedCount_tDBOutput_1=0;
int insertedCount_tDBOutput_1=0;
int rowsToCommitCount_tDBOutput_1=0;
int rejectedCount_tDBOutput_1=0;

boolean whetherReject_tDBOutput_1 = false;

java.sql.Connection conn_tDBOutput_1 = null;
String dbUser_tDBOutput_1 = null;

	conn_tDBOutput_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_2");
	
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Uses an existing connection with username '")  + (conn_tDBOutput_1.getMetaData().getUserName())  + ("'. Connection URL: ")  + (conn_tDBOutput_1.getMetaData().getURL())  + (".") );
	
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection is set auto commit to '")  + (conn_tDBOutput_1.getAutoCommit())  + ("'.") );


   int batchSize_tDBOutput_1 = 10000;
   int batchSizeCounter_tDBOutput_1=0;

int count_tDBOutput_1=0;
	    String update_tDBOutput_1 = "UPDATE \"" + tableName_tDBOutput_1 + "\" SET \"user_key\" = ?,\"session_key\" = ?,\"artist_key\" = ?,\"song_key\" = ?,\"total_sesssion_duration\" = ?,\"subscription_type\" = ? WHERE \"listening_activity_key\" = ?";
	    java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(update_tDBOutput_1);
	    resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
	    

 



/**
 * [tDBOutput_1 begin ] stop
 */




	
	/**
	 * [tDBOutput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_2", false);
		start_Hash.put("tDBOutput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_2";

	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"NotFound1");
			
		int tos_count_tDBOutput_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBOutput_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBOutput_2 = new StringBuilder();
                    log4jParamters_tDBOutput_2.append("Parameters:");
                            log4jParamters_tDBOutput_2.append("USE_EXISTING_CONNECTION" + " = " + "true");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("CONNECTION" + " = " + "tDBConnection_2");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("TABLE" + " = " + "\"listening_activity\"");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("TABLE_ACTION" + " = " + "NONE");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("DATA_ACTION" + " = " + "INSERT");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("DIE_ON_ERROR" + " = " + "false");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("USE_ALTERNATE_SCHEMA" + " = " + "false");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("ADD_COLS" + " = " + "[{POS="+("REPLACE")+", REFCOL="+("listening_activity_key")+", NAME="+("\"listening_activity_key\"")+", SQL="+("\"nextval('ladim_lakey_sequence')\"")+"}]");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("USE_FIELD_OPTIONS" + " = " + "false");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("ENABLE_DEBUG_MODE" + " = " + "false");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("SUPPORT_NULL_WHERE" + " = " + "false");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("CONVERT_COLUMN_TABLE_TO_LOWERCASE" + " = " + "false");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("USE_BATCH_SIZE" + " = " + "true");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("BATCH_SIZE" + " = " + "100000");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlOutput");
                        log4jParamters_tDBOutput_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + (log4jParamters_tDBOutput_2) );
                    } 
                } 
            new BytesLimit65535_tDBOutput_2().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBOutput_2", "__TABLE__", "tPostgresqlOutput");
				talendJobLogProcess(globalMap);
			}
			





String dbschema_tDBOutput_2 = null;
	dbschema_tDBOutput_2 = (String)globalMap.get("schema_" + "tDBConnection_2");
	

String tableName_tDBOutput_2 = null;
if(dbschema_tDBOutput_2 == null || dbschema_tDBOutput_2.trim().length() == 0) {
	tableName_tDBOutput_2 = ("listening_activity");
} else {
	tableName_tDBOutput_2 = dbschema_tDBOutput_2 + "\".\"" + ("listening_activity");
}


int nb_line_tDBOutput_2 = 0;
int nb_line_update_tDBOutput_2 = 0;
int nb_line_inserted_tDBOutput_2 = 0;
int nb_line_deleted_tDBOutput_2 = 0;
int nb_line_rejected_tDBOutput_2 = 0;

int deletedCount_tDBOutput_2=0;
int updatedCount_tDBOutput_2=0;
int insertedCount_tDBOutput_2=0;
int rowsToCommitCount_tDBOutput_2=0;
int rejectedCount_tDBOutput_2=0;

boolean whetherReject_tDBOutput_2 = false;

java.sql.Connection conn_tDBOutput_2 = null;
String dbUser_tDBOutput_2 = null;

	conn_tDBOutput_2 = (java.sql.Connection)globalMap.get("conn_tDBConnection_2");
	
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Uses an existing connection with username '")  + (conn_tDBOutput_2.getMetaData().getUserName())  + ("'. Connection URL: ")  + (conn_tDBOutput_2.getMetaData().getURL())  + (".") );
	
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Connection is set auto commit to '")  + (conn_tDBOutput_2.getAutoCommit())  + ("'.") );


   int batchSize_tDBOutput_2 = 100000;
   int batchSizeCounter_tDBOutput_2=0;

int count_tDBOutput_2=0;
	    String insert_tDBOutput_2 = "INSERT INTO \"" + tableName_tDBOutput_2 + "\" (\"" + "listening_activity_key" + "\",\"user_key\",\"session_key\",\"artist_key\",\"song_key\",\"total_sesssion_duration\",\"subscription_type\") VALUES (" + "nextval('ladim_lakey_sequence')" + ",?,?,?,?,?,?)";
	    
	    java.sql.PreparedStatement pstmt_tDBOutput_2 = conn_tDBOutput_2.prepareStatement(insert_tDBOutput_2);
	    resourceMap.put("pstmt_tDBOutput_2", pstmt_tDBOutput_2);
	    

 



/**
 * [tDBOutput_2 begin ] stop
 */



	
	/**
	 * [tMap_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_1", false);
		start_Hash.put("tMap_1", System.currentTimeMillis());
		
	
	currentComponent="tMap_1";

	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row1");
			
		int tos_count_tMap_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tMap_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tMap_1 = new StringBuilder();
                    log4jParamters_tMap_1.append("Parameters:");
                            log4jParamters_tMap_1.append("LINK_STYLE" + " = " + "AUTO");
                        log4jParamters_tMap_1.append(" | ");
                            log4jParamters_tMap_1.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
                        log4jParamters_tMap_1.append(" | ");
                            log4jParamters_tMap_1.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
                        log4jParamters_tMap_1.append(" | ");
                            log4jParamters_tMap_1.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
                        log4jParamters_tMap_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + (log4jParamters_tMap_1) );
                    } 
                } 
            new BytesLimit65535_tMap_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tMap_1", "tMap_1", "tMap");
				talendJobLogProcess(globalMap);
			}
			




// ###############################
// # Lookup's keys initialization
		int count_row1_tMap_1 = 0;
		
		int count_row2_tMap_1 = 0;
		
		int count_row3_tMap_1 = 0;
		
		int count_row8_tMap_1 = 0;
		
		int count_row7_tMap_1 = 0;
		
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
					globalMap.get( "tHash_Lookup_row2" ))
					;					
					
	

row2Struct row2HashKey = new row2Struct();
row2Struct row2Default = new row2Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) 
					globalMap.get( "tHash_Lookup_row3" ))
					;					
					
	

row3Struct row3HashKey = new row3Struct();
row3Struct row3Default = new row3Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row8Struct> tHash_Lookup_row8 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row8Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row8Struct>) 
					globalMap.get( "tHash_Lookup_row8" ))
					;					
					
	

row8Struct row8HashKey = new row8Struct();
row8Struct row8Default = new row8Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row7Struct> tHash_Lookup_row7 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row7Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row7Struct>) 
					globalMap.get( "tHash_Lookup_row7" ))
					;					
					
	

row7Struct row7HashKey = new row7Struct();
row7Struct row7Default = new row7Struct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_Found1_tMap_1 = 0;
				
Found1Struct Found1_tmp = new Found1Struct();
				int count_NotFound1_tMap_1 = 0;
				
NotFound1Struct NotFound1_tmp = new NotFound1Struct();
// ###############################

        
        



        









 



/**
 * [tMap_1 begin ] stop
 */



	
	/**
	 * [tDBInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_1", false);
		start_Hash.put("tDBInput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_1";

	
		int tos_count_tDBInput_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBInput_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBInput_1 = new StringBuilder();
                    log4jParamters_tDBInput_1.append("Parameters:");
                            log4jParamters_tDBInput_1.append("USE_EXISTING_CONNECTION" + " = " + "true");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("CONNECTION" + " = " + "tDBConnection_2");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("QUERY" + " = " + "\"SELECT * FROM SESSIONSDIM;\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("USE_CURSOR" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("sessionkey")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("session_id")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("userkey")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("songkey")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("session_duration")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("timekey")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("datekey")+"}]");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlInput");
                        log4jParamters_tDBInput_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + (log4jParamters_tDBInput_1) );
                    } 
                } 
            new BytesLimit65535_tDBInput_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBInput_1", "__TABLE__", "tPostgresqlInput");
				talendJobLogProcess(globalMap);
			}
			
	
    
	
		    int nb_line_tDBInput_1 = 0;
		    java.sql.Connection conn_tDBInput_1 = null;
				conn_tDBInput_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_2");
				
				if(conn_tDBInput_1 != null) {
					if(conn_tDBInput_1.getMetaData() != null) {
						
							log.debug("tDBInput_1 - Uses an existing connection with username '" + conn_tDBInput_1.getMetaData().getUserName() + "'. Connection URL: " + conn_tDBInput_1.getMetaData().getURL() + ".");
						
					}
				}
			
		    
			java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

		    String dbquery_tDBInput_1 = "SELECT * FROM SESSIONSDIM;";
		    
	    		log.debug("tDBInput_1 - Executing the query: '" + dbquery_tDBInput_1 + "'.");
			

            	globalMap.put("tDBInput_1_QUERY",dbquery_tDBInput_1);
		    java.sql.ResultSet rs_tDBInput_1 = null;

		    try {
		    	rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
		    	int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

		    String tmpContent_tDBInput_1 = null;
		    
		    
		    	log.debug("tDBInput_1 - Retrieving records from the database.");
		    
		    while (rs_tDBInput_1.next()) {
		        nb_line_tDBInput_1++;
		        
							if(colQtyInRs_tDBInput_1 < 1) {
								row1.sessionkey = 0;
							} else {
		                          
            row1.sessionkey = rs_tDBInput_1.getInt(1);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.session_id = null;
							} else {
	                         		
        	row1.session_id = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.userkey = 0;
							} else {
		                          
            row1.userkey = rs_tDBInput_1.getInt(3);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row1.songkey = 0;
							} else {
		                          
            row1.songkey = rs_tDBInput_1.getInt(4);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row1.session_duration = null;
							} else {
		                          
            row1.session_duration = rs_tDBInput_1.getBigDecimal(5);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row1.timekey = 0;
							} else {
		                          
            row1.timekey = rs_tDBInput_1.getInt(6);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								row1.datekey = 0;
							} else {
		                          
            row1.datekey = rs_tDBInput_1.getInt(7);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
					
						log.debug("tDBInput_1 - Retrieving the record " + nb_line_tDBInput_1 + ".");
					


 



/**
 * [tDBInput_1 begin ] stop
 */
	
	/**
	 * [tDBInput_1 main ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 


	tos_count_tDBInput_1++;

/**
 * [tDBInput_1 main ] stop
 */
	
	/**
	 * [tDBInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";

	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row1","tDBInput_1","__TABLE__","tPostgresqlInput","tMap_1","tMap_1","tMap"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row1 - " + (row1==null? "": row1.toLogString()));
    			}
    		

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_1 = false;
		  boolean mainRowRejected_tMap_1 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row2" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow2 = false;
       		  	    	
       		  	    	
 							row2Struct row2ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
	                        		    	Object exprKeyValue_row2__userkey = row1.userkey ;
	                        		    	if(exprKeyValue_row2__userkey == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row2HashKey.userkey = (int)(Integer) exprKeyValue_row2__userkey;
                        		    		}
                        		    		

								
		                        	row2HashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_row2.lookup( row2HashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
								  
								  if(hasCasePrimitiveKeyWithNull_tMap_1 || !tHash_Lookup_row2.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_1 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row2 != null && tHash_Lookup_row2.getCount(row2HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row2' and it contains more one result from keys :  row2.userkey = '" + row2HashKey.userkey + "'");
								} // G 071
							

							row2Struct row2 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row2Struct fromLookup_row2 = null;
							row2 = row2Default;
										 
							
								 
							
							
								if (tHash_Lookup_row2 !=null && tHash_Lookup_row2.hasNext()) { // G 099
								
							
								
								fromLookup_row2 = tHash_Lookup_row2.next();

							
							
								} // G 099
							
							

							if(fromLookup_row2 != null) {
								row2 = fromLookup_row2;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row3" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow3 = false;
       		  	    	
       		  	    	
 							row3Struct row3ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
	                        		    	Object exprKeyValue_row3__songkey = row1.songkey ;
	                        		    	if(exprKeyValue_row3__songkey == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row3HashKey.songkey = (int)(Integer) exprKeyValue_row3__songkey;
                        		    		}
                        		    		

								
		                        	row3HashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_row3.lookup( row3HashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
								  
								  if(hasCasePrimitiveKeyWithNull_tMap_1 || !tHash_Lookup_row3.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_1 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3' and it contains more one result from keys :  row3.songkey = '" + row3HashKey.songkey + "'");
								} // G 071
							

							row3Struct row3 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row3Struct fromLookup_row3 = null;
							row3 = row3Default;
										 
							
								 
							
							
								if (tHash_Lookup_row3 !=null && tHash_Lookup_row3.hasNext()) { // G 099
								
							
								
								fromLookup_row3 = tHash_Lookup_row3.next();

							
							
								} // G 099
							
							

							if(fromLookup_row3 != null) {
								row3 = fromLookup_row3;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row8" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow8 = false;
       		  	    	
       		  	    	
 							row8Struct row8ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
	                        		    	Object exprKeyValue_row8__artistkey = row3.artistkey ;
	                        		    	if(exprKeyValue_row8__artistkey == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row8HashKey.artistkey = (int)(Integer) exprKeyValue_row8__artistkey;
                        		    		}
                        		    		

								
		                        	row8HashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_row8.lookup( row8HashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
								  
								  if(hasCasePrimitiveKeyWithNull_tMap_1 || !tHash_Lookup_row8.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_1 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row8 != null && tHash_Lookup_row8.getCount(row8HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row8' and it contains more one result from keys :  row8.artistkey = '" + row8HashKey.artistkey + "'");
								} // G 071
							

							row8Struct row8 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row8Struct fromLookup_row8 = null;
							row8 = row8Default;
										 
							
								 
							
							
								if (tHash_Lookup_row8 !=null && tHash_Lookup_row8.hasNext()) { // G 099
								
							
								
								fromLookup_row8 = tHash_Lookup_row8.next();

							
							
								} // G 099
							
							

							if(fromLookup_row8 != null) {
								row8 = fromLookup_row8;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row7" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow7 = false;
       		  	    	
       		  	    	
 							row7Struct row7ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
	                        		    	Object exprKeyValue_row7__user_key = row2.userkey ;
	                        		    	if(exprKeyValue_row7__user_key == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row7HashKey.user_key = (int)(Integer) exprKeyValue_row7__user_key;
                        		    		}
                        		    		
	                        		    	Object exprKeyValue_row7__session_key = row1.sessionkey ;
	                        		    	if(exprKeyValue_row7__session_key == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row7HashKey.session_key = (int)(Integer) exprKeyValue_row7__session_key;
                        		    		}
                        		    		
	                        		    	Object exprKeyValue_row7__artist_key = row8.artistkey ;
	                        		    	if(exprKeyValue_row7__artist_key == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row7HashKey.artist_key = (int)(Integer) exprKeyValue_row7__artist_key;
                        		    		}
                        		    		
	                        		    	Object exprKeyValue_row7__song_key = row3.songkey ;
	                        		    	if(exprKeyValue_row7__song_key == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row7HashKey.song_key = (int)(Integer) exprKeyValue_row7__song_key;
                        		    		}
                        		    		
                        		    		    row7HashKey.total_sesssion_duration = row1.session_duration.divide(new BigDecimal("60"), 2, java.math.RoundingMode.HALF_UP) ;
                        		    		
	                        		    	Object exprKeyValue_row7__subscription_type = row2.subscriptiontype.equals("paid") ? 1 : 0;
	                        		    	if(exprKeyValue_row7__subscription_type == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row7HashKey.subscription_type = (int)(Integer) exprKeyValue_row7__subscription_type;
                        		    		}
                        		    		

								
		                        	row7HashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_row7.lookup( row7HashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
								  
								  if(hasCasePrimitiveKeyWithNull_tMap_1 || !tHash_Lookup_row7.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_1 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row7 != null && tHash_Lookup_row7.getCount(row7HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row7' and it contains more one result from keys :  row7.user_key = '" + row7HashKey.user_key + "', row7.session_key = '" + row7HashKey.session_key + "', row7.artist_key = '" + row7HashKey.artist_key + "', row7.song_key = '" + row7HashKey.song_key + "', row7.total_sesssion_duration = '" + row7HashKey.total_sesssion_duration + "', row7.subscription_type = '" + row7HashKey.subscription_type + "'");
								} // G 071
							

							row7Struct row7 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row7Struct fromLookup_row7 = null;
							row7 = row7Default;
										 
							
								 
							
							
								if (tHash_Lookup_row7 !=null && tHash_Lookup_row7.hasNext()) { // G 099
								
							
								
								fromLookup_row7 = tHash_Lookup_row7.next();

							
							
								} // G 099
							
							

							if(fromLookup_row7 != null) {
								row7 = fromLookup_row7;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

Found1 = null;
NotFound1 = null;

if(!rejectedInnerJoin_tMap_1 ) {

// # Output table : 'Found1'
count_Found1_tMap_1++;

Found1_tmp.listening_activity_key = row7.listening_activity_key ;
Found1_tmp.user_key = row7.user_key ;
Found1_tmp.session_key = row7.session_key ;
Found1_tmp.artist_key = row7.artist_key ;
Found1_tmp.song_key = row7.song_key ;
Found1_tmp.total_sesssion_duration = row7.total_sesssion_duration ;
Found1_tmp.subscription_type = row7.subscription_type ;
Found1 = Found1_tmp;
log.debug("tMap_1 - Outputting the record " + count_Found1_tMap_1 + " of the output table 'Found1'.");

} // closing inner join bracket (1)
// ###### START REJECTS ##### 

// # Output reject table : 'NotFound1'
// # Filter conditions 
if( rejectedInnerJoin_tMap_1 ) {
count_NotFound1_tMap_1++;

NotFound1_tmp.listening_activity_key = 0;
NotFound1_tmp.user_key = row2.userkey ;
NotFound1_tmp.session_key = row1.sessionkey ;
NotFound1_tmp.artist_key = row3.artistkey ;
NotFound1_tmp.song_key = row3.songkey ;
NotFound1_tmp.total_sesssion_duration = row1.session_duration.divide(new BigDecimal("60"), 2, java.math.RoundingMode.HALF_UP) ;
NotFound1_tmp.subscription_type = row2.subscriptiontype.equals("paid") ? 1 : 0;
NotFound1 = NotFound1_tmp;
log.debug("tMap_1 - Outputting the record " + count_NotFound1_tMap_1 + " of the output table 'NotFound1'.");

} // closing filter/reject
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_1 = false;










 


	tos_count_tMap_1++;

/**
 * [tMap_1 main ] stop
 */
	
	/**
	 * [tMap_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_begin ] stop
 */
// Start of branch "Found1"
if(Found1 != null) { 



	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"Found1","tMap_1","tMap_1","tMap","tDBOutput_1","__TABLE__","tPostgresqlOutput"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("Found1 - " + (Found1==null? "": Found1.toLogString()));
    			}
    		



        whetherReject_tDBOutput_1 = false;
                    pstmt_tDBOutput_1.setInt(1, Found1.user_key);

                    pstmt_tDBOutput_1.setInt(2, Found1.session_key);

                    pstmt_tDBOutput_1.setInt(3, Found1.artist_key);

                    pstmt_tDBOutput_1.setInt(4, Found1.song_key);

                    pstmt_tDBOutput_1.setBigDecimal(5, Found1.total_sesssion_duration);

                    pstmt_tDBOutput_1.setInt(6, Found1.subscription_type);

                    pstmt_tDBOutput_1.setInt(7 + count_tDBOutput_1, Found1.listening_activity_key);


    		pstmt_tDBOutput_1.addBatch();
    		nb_line_tDBOutput_1++;
    		  
    		  
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Adding the record ")  + (nb_line_tDBOutput_1)  + (" to the ")  + ("UPDATE")  + (" batch.") );
    		  batchSizeCounter_tDBOutput_1++;
    		  
    			if ((batchSize_tDBOutput_1 > 0) && (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1)) {
                try {
						int countSum_tDBOutput_1 = 0;
						    
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Executing the ")  + ("UPDATE")  + (" batch.") );
						for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
							countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
						}
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("The ")  + ("UPDATE")  + (" batch execution has succeeded.") );
				    	rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
				    	
				    		updatedCount_tDBOutput_1 += countSum_tDBOutput_1;
				    	
            	    	batchSizeCounter_tDBOutput_1 = 0;
                }catch (java.sql.BatchUpdateException e_tDBOutput_1){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e_tDBOutput_1.getMessage());
				    	java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1.getNextException(),sqle_tDBOutput_1=null;
				    	String errormessage_tDBOutput_1;
						if (ne_tDBOutput_1 != null) {
							// build new exception to provide the original cause
							sqle_tDBOutput_1 = new java.sql.SQLException(e_tDBOutput_1.getMessage() + "\ncaused by: " + ne_tDBOutput_1.getMessage(), ne_tDBOutput_1.getSQLState(), ne_tDBOutput_1.getErrorCode(), ne_tDBOutput_1);
							errormessage_tDBOutput_1 = sqle_tDBOutput_1.getMessage();
						}else{
							errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
						}
				    	
				    	int countSum_tDBOutput_1 = 0;
						for(int countEach_tDBOutput_1: e_tDBOutput_1.getUpdateCounts()) {
							countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
						}
						rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
						
				    		updatedCount_tDBOutput_1 += countSum_tDBOutput_1;
				    	
            log.error("tDBOutput_1 - "  + (errormessage_tDBOutput_1) );
				    	System.err.println(errormessage_tDBOutput_1);
				    	
					}
    			}
    		

 


	tos_count_tDBOutput_1++;

/**
 * [tDBOutput_1 main ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_end ] stop
 */

} // End of branch "Found1"




// Start of branch "NotFound1"
if(NotFound1 != null) { 



	
	/**
	 * [tDBOutput_2 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"NotFound1","tMap_1","tMap_1","tMap","tDBOutput_2","__TABLE__","tPostgresqlOutput"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("NotFound1 - " + (NotFound1==null? "": NotFound1.toLogString()));
    			}
    		



        whetherReject_tDBOutput_2 = false;
                    pstmt_tDBOutput_2.setInt(1, NotFound1.user_key);

                    pstmt_tDBOutput_2.setInt(2, NotFound1.session_key);

                    pstmt_tDBOutput_2.setInt(3, NotFound1.artist_key);

                    pstmt_tDBOutput_2.setInt(4, NotFound1.song_key);

                    pstmt_tDBOutput_2.setBigDecimal(5, NotFound1.total_sesssion_duration);

                    pstmt_tDBOutput_2.setInt(6, NotFound1.subscription_type);

			
    		pstmt_tDBOutput_2.addBatch();
    		nb_line_tDBOutput_2++;
    		  
    		  
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Adding the record ")  + (nb_line_tDBOutput_2)  + (" to the ")  + ("INSERT")  + (" batch.") );
    		  batchSizeCounter_tDBOutput_2++;
    		  
    			if ((batchSize_tDBOutput_2 > 0) && (batchSize_tDBOutput_2 <= batchSizeCounter_tDBOutput_2)) {
                try {
						int countSum_tDBOutput_2 = 0;
						    
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Executing the ")  + ("INSERT")  + (" batch.") );
						for(int countEach_tDBOutput_2: pstmt_tDBOutput_2.executeBatch()) {
							countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
						}
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("The ")  + ("INSERT")  + (" batch execution has succeeded.") );
				    	rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
				    	
				    		insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
				    	
            	    	batchSizeCounter_tDBOutput_2 = 0;
                }catch (java.sql.BatchUpdateException e_tDBOutput_2){
globalMap.put("tDBOutput_2_ERROR_MESSAGE",e_tDBOutput_2.getMessage());
				    	java.sql.SQLException ne_tDBOutput_2 = e_tDBOutput_2.getNextException(),sqle_tDBOutput_2=null;
				    	String errormessage_tDBOutput_2;
						if (ne_tDBOutput_2 != null) {
							// build new exception to provide the original cause
							sqle_tDBOutput_2 = new java.sql.SQLException(e_tDBOutput_2.getMessage() + "\ncaused by: " + ne_tDBOutput_2.getMessage(), ne_tDBOutput_2.getSQLState(), ne_tDBOutput_2.getErrorCode(), ne_tDBOutput_2);
							errormessage_tDBOutput_2 = sqle_tDBOutput_2.getMessage();
						}else{
							errormessage_tDBOutput_2 = e_tDBOutput_2.getMessage();
						}
				    	
				    	int countSum_tDBOutput_2 = 0;
						for(int countEach_tDBOutput_2: e_tDBOutput_2.getUpdateCounts()) {
							countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
						}
						rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
						
				    		insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
				    	
            log.error("tDBOutput_2 - "  + (errormessage_tDBOutput_2) );
				    	System.err.println(errormessage_tDBOutput_2);
				    	
					}
    			}
    		

 


	tos_count_tDBOutput_2++;

/**
 * [tDBOutput_2 main ] stop
 */
	
	/**
	 * [tDBOutput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	

 



/**
 * [tDBOutput_2 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	

 



/**
 * [tDBOutput_2 process_data_end ] stop
 */

} // End of branch "NotFound1"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_1 end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

	}
}finally{
	if (rs_tDBInput_1 != null) {
		rs_tDBInput_1.close();
	}
	if (stmt_tDBInput_1 != null) {
		stmt_tDBInput_1.close();
	}
}
globalMap.put("tDBInput_1_NB_LINE",nb_line_tDBInput_1);
	    		log.debug("tDBInput_1 - Retrieved records count: "+nb_line_tDBInput_1 + " .");
			
 
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + ("Done.") );

ok_Hash.put("tDBInput_1", true);
end_Hash.put("tDBInput_1", System.currentTimeMillis());




/**
 * [tDBInput_1 end ] stop
 */

	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_row2 != null) {
						tHash_Lookup_row2.endGet();
					}
					globalMap.remove( "tHash_Lookup_row2" );

					
					
				
					if(tHash_Lookup_row3 != null) {
						tHash_Lookup_row3.endGet();
					}
					globalMap.remove( "tHash_Lookup_row3" );

					
					
				
					if(tHash_Lookup_row8 != null) {
						tHash_Lookup_row8.endGet();
					}
					globalMap.remove( "tHash_Lookup_row8" );

					
					
				
					if(tHash_Lookup_row7 != null) {
						tHash_Lookup_row7.endGet();
					}
					globalMap.remove( "tHash_Lookup_row7" );

					
					
				
// ###############################      
				log.debug("tMap_1 - Written records count in the table 'Found1': " + count_Found1_tMap_1 + ".");
				log.debug("tMap_1 - Written records count in the table 'NotFound1': " + count_NotFound1_tMap_1 + ".");





			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row1",2,0,
			 			"tDBInput_1","__TABLE__","tPostgresqlInput","tMap_1","tMap_1","tMap","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + ("Done.") );

ok_Hash.put("tMap_1", true);
end_Hash.put("tMap_1", System.currentTimeMillis());




/**
 * [tMap_1 end ] stop
 */

	
	/**
	 * [tDBOutput_1 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



	    try {
				int countSum_tDBOutput_1 = 0;
				if (pstmt_tDBOutput_1 != null && batchSizeCounter_tDBOutput_1 > 0) {
						
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Executing the ")  + ("UPDATE")  + (" batch.") );
					for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
						
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("The ")  + ("UPDATE")  + (" batch execution has succeeded.") );
				}
		    	
		    		updatedCount_tDBOutput_1 += countSum_tDBOutput_1;
		    	
	    }catch (java.sql.BatchUpdateException e_tDBOutput_1){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e_tDBOutput_1.getMessage());
	    	java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1.getNextException(),sqle_tDBOutput_1=null;
	    	String errormessage_tDBOutput_1;
			if (ne_tDBOutput_1 != null) {
				// build new exception to provide the original cause
				sqle_tDBOutput_1 = new java.sql.SQLException(e_tDBOutput_1.getMessage() + "\ncaused by: " + ne_tDBOutput_1.getMessage(), ne_tDBOutput_1.getSQLState(), ne_tDBOutput_1.getErrorCode(), ne_tDBOutput_1);
				errormessage_tDBOutput_1 = sqle_tDBOutput_1.getMessage();
			}else{
				errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
			}
	    	
	    	int countSum_tDBOutput_1 = 0;
			for(int countEach_tDBOutput_1: e_tDBOutput_1.getUpdateCounts()) {
				countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
			}
			rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
			
	    		updatedCount_tDBOutput_1 += countSum_tDBOutput_1;
	    	
            log.error("tDBOutput_1 - "  + (errormessage_tDBOutput_1) );
	    	System.err.println(errormessage_tDBOutput_1);
	    	
		}
	    
        if(pstmt_tDBOutput_1 != null) {
        		
            pstmt_tDBOutput_1.close();
            resourceMap.remove("pstmt_tDBOutput_1");
        }
    resourceMap.put("statementClosed_tDBOutput_1", true);

	nb_line_deleted_tDBOutput_1=nb_line_deleted_tDBOutput_1+ deletedCount_tDBOutput_1;
	nb_line_update_tDBOutput_1=nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
	nb_line_inserted_tDBOutput_1=nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
	nb_line_rejected_tDBOutput_1=nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;
	
        globalMap.put("tDBOutput_1_NB_LINE",nb_line_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_UPDATED",nb_line_update_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_DELETED",nb_line_deleted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);
    

	


			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"Found1",2,0,
			 			"tMap_1","tMap_1","tMap","tDBOutput_1","__TABLE__","tPostgresqlOutput","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Done.") );

ok_Hash.put("tDBOutput_1", true);
end_Hash.put("tDBOutput_1", System.currentTimeMillis());




/**
 * [tDBOutput_1 end ] stop
 */




	
	/**
	 * [tDBOutput_2 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	



	    try {
				int countSum_tDBOutput_2 = 0;
				if (pstmt_tDBOutput_2 != null && batchSizeCounter_tDBOutput_2 > 0) {
						
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Executing the ")  + ("INSERT")  + (" batch.") );
					for(int countEach_tDBOutput_2: pstmt_tDBOutput_2.executeBatch()) {
						countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
					}
					rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
						
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("The ")  + ("INSERT")  + (" batch execution has succeeded.") );
				}
		    	
		    		insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
		    	
	    }catch (java.sql.BatchUpdateException e_tDBOutput_2){
globalMap.put("tDBOutput_2_ERROR_MESSAGE",e_tDBOutput_2.getMessage());
	    	java.sql.SQLException ne_tDBOutput_2 = e_tDBOutput_2.getNextException(),sqle_tDBOutput_2=null;
	    	String errormessage_tDBOutput_2;
			if (ne_tDBOutput_2 != null) {
				// build new exception to provide the original cause
				sqle_tDBOutput_2 = new java.sql.SQLException(e_tDBOutput_2.getMessage() + "\ncaused by: " + ne_tDBOutput_2.getMessage(), ne_tDBOutput_2.getSQLState(), ne_tDBOutput_2.getErrorCode(), ne_tDBOutput_2);
				errormessage_tDBOutput_2 = sqle_tDBOutput_2.getMessage();
			}else{
				errormessage_tDBOutput_2 = e_tDBOutput_2.getMessage();
			}
	    	
	    	int countSum_tDBOutput_2 = 0;
			for(int countEach_tDBOutput_2: e_tDBOutput_2.getUpdateCounts()) {
				countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
			}
			rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
			
	    		insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
	    	
            log.error("tDBOutput_2 - "  + (errormessage_tDBOutput_2) );
	    	System.err.println(errormessage_tDBOutput_2);
	    	
		}
	    
        if(pstmt_tDBOutput_2 != null) {
        		
            pstmt_tDBOutput_2.close();
            resourceMap.remove("pstmt_tDBOutput_2");
        }
    resourceMap.put("statementClosed_tDBOutput_2", true);

	nb_line_deleted_tDBOutput_2=nb_line_deleted_tDBOutput_2+ deletedCount_tDBOutput_2;
	nb_line_update_tDBOutput_2=nb_line_update_tDBOutput_2 + updatedCount_tDBOutput_2;
	nb_line_inserted_tDBOutput_2=nb_line_inserted_tDBOutput_2 + insertedCount_tDBOutput_2;
	nb_line_rejected_tDBOutput_2=nb_line_rejected_tDBOutput_2 + rejectedCount_tDBOutput_2;
	
        globalMap.put("tDBOutput_2_NB_LINE",nb_line_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_UPDATED",nb_line_update_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_DELETED",nb_line_deleted_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_2);
    

	


			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"NotFound1",2,0,
			 			"tMap_1","tMap_1","tMap","tDBOutput_2","__TABLE__","tPostgresqlOutput","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Done.") );

ok_Hash.put("tDBOutput_2", true);
end_Hash.put("tDBOutput_2", System.currentTimeMillis());




/**
 * [tDBOutput_2 end ] stop
 */






				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tDBInput_1:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk1", 0, "ok");
								} 
							
							tDBCommit_2Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row2"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row3"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row7"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row8"); 
				     			
				try{
					
	
	/**
	 * [tDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 finally ] stop
 */

	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 finally ] stop
 */

	
	/**
	 * [tDBOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



    if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
                if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_1")) != null) {
                    pstmtToClose_tDBOutput_1.close();
                }
    }
 



/**
 * [tDBOutput_1 finally ] stop
 */




	
	/**
	 * [tDBOutput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	



    if (resourceMap.get("statementClosed_tDBOutput_2") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_2 = null;
                if ((pstmtToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_2")) != null) {
                    pstmtToClose_tDBOutput_2.close();
                }
    }
 



/**
 * [tDBOutput_2 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBCommit_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBCommit_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tDBCommit_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBCommit_2", false);
		start_Hash.put("tDBCommit_2", System.currentTimeMillis());
		
	
	currentComponent="tDBCommit_2";

	
		int tos_count_tDBCommit_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBCommit_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBCommit_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBCommit_2 = new StringBuilder();
                    log4jParamters_tDBCommit_2.append("Parameters:");
                            log4jParamters_tDBCommit_2.append("CONNECTION" + " = " + "tDBConnection_2");
                        log4jParamters_tDBCommit_2.append(" | ");
                            log4jParamters_tDBCommit_2.append("CLOSE" + " = " + "false");
                        log4jParamters_tDBCommit_2.append(" | ");
                            log4jParamters_tDBCommit_2.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlCommit");
                        log4jParamters_tDBCommit_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBCommit_2 - "  + (log4jParamters_tDBCommit_2) );
                    } 
                } 
            new BytesLimit65535_tDBCommit_2().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBCommit_2", "tDBCommit_2", "tPostgresqlCommit");
				talendJobLogProcess(globalMap);
			}
			

 



/**
 * [tDBCommit_2 begin ] stop
 */
	
	/**
	 * [tDBCommit_2 main ] start
	 */

	

	
	
	currentComponent="tDBCommit_2";

	

	java.sql.Connection conn_tDBCommit_2 = (java.sql.Connection)globalMap.get("conn_tDBConnection_2");
	if(conn_tDBCommit_2 != null && !conn_tDBCommit_2.isClosed())
	{
	
			
	    		log.debug("tDBCommit_2 - Connection 'tDBConnection_2' starting to commit.");
			
			conn_tDBCommit_2.commit();
			
	    		log.debug("tDBCommit_2 - Connection 'tDBConnection_2' commit has succeeded.");
			
	
	}

 


	tos_count_tDBCommit_2++;

/**
 * [tDBCommit_2 main ] stop
 */
	
	/**
	 * [tDBCommit_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBCommit_2";

	

 



/**
 * [tDBCommit_2 process_data_begin ] stop
 */
	
	/**
	 * [tDBCommit_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBCommit_2";

	

 



/**
 * [tDBCommit_2 process_data_end ] stop
 */
	
	/**
	 * [tDBCommit_2 end ] start
	 */

	

	
	
	currentComponent="tDBCommit_2";

	

 
                if(log.isDebugEnabled())
            log.debug("tDBCommit_2 - "  + ("Done.") );

ok_Hash.put("tDBCommit_2", true);
end_Hash.put("tDBCommit_2", System.currentTimeMillis());




/**
 * [tDBCommit_2 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBCommit_2 finally ] start
	 */

	

	
	
	currentComponent="tDBCommit_2";

	

 



/**
 * [tDBCommit_2 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBCommit_2_SUBPROCESS_STATE", 1);
	}
	


public static class row2Struct implements routines.system.IPersistableComparableLookupRow<row2Struct> {
    final static byte[] commonByteArrayLock_ARTISTLOC_FactTable = new byte[0];
    static byte[] commonByteArray_ARTISTLOC_FactTable = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int userkey;

				public int getUserkey () {
					return this.userkey;
				}
				
			    public int userid;

				public int getUserid () {
					return this.userid;
				}
				
			    public String first_name;

				public String getFirst_name () {
					return this.first_name;
				}
				
			    public String last_name;

				public String getLast_name () {
					return this.last_name;
				}
				
			    public String gender;

				public String getGender () {
					return this.gender;
				}
				
			    public String subscriptiontype;

				public String getSubscriptiontype () {
					return this.subscriptiontype;
				}
				
			    public java.util.Date startdate;

				public java.util.Date getStartdate () {
					return this.startdate;
				}
				
			    public java.util.Date enddate;

				public java.util.Date getEnddate () {
					return this.enddate;
				}
				
			    public String status;

				public String getStatus () {
					return this.status;
				}
				
			    public int citykey;

				public int getCitykey () {
					return this.citykey;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.userkey;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row2Struct other = (row2Struct) obj;
		
						if (this.userkey != other.userkey)
							return false;
					

		return true;
    }

	public void copyDataTo(row2Struct other) {

		other.userkey = this.userkey;
	            other.userid = this.userid;
	            other.first_name = this.first_name;
	            other.last_name = this.last_name;
	            other.gender = this.gender;
	            other.subscriptiontype = this.subscriptiontype;
	            other.startdate = this.startdate;
	            other.enddate = this.enddate;
	            other.status = this.status;
	            other.citykey = this.citykey;
	            
	}

	public void copyKeysDataTo(row2Struct other) {

		other.userkey = this.userkey;
	            	
	}



	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

	private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller ) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

	private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
	}
	
	private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ARTISTLOC_FactTable) {

        	try {

        		int length = 0;
		
			        this.userkey = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ARTISTLOC_FactTable) {

        	try {

        		int length = 0;
		
			        this.userkey = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.userkey);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.userkey);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
			            this.userid = dis.readInt();
					
						this.first_name = readString(dis,ois);
					
						this.last_name = readString(dis,ois);
					
						this.gender = readString(dis,ois);
					
						this.subscriptiontype = readString(dis,ois);
					
						this.startdate = readDate(dis,ois);
					
						this.enddate = readDate(dis,ois);
					
						this.status = readString(dis,ois);
					
			            this.citykey = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.userid = objectIn.readInt();
					
						this.first_name = readString(dis,objectIn);
					
						this.last_name = readString(dis,objectIn);
					
						this.gender = readString(dis,objectIn);
					
						this.subscriptiontype = readString(dis,objectIn);
					
						this.startdate = readDate(dis,objectIn);
					
						this.enddate = readDate(dis,objectIn);
					
						this.status = readString(dis,objectIn);
					
			            this.citykey = objectIn.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.userid);
					
						writeString(this.first_name, dos, oos);
					
						writeString(this.last_name, dos, oos);
					
						writeString(this.gender, dos, oos);
					
						writeString(this.subscriptiontype, dos, oos);
					
						writeDate(this.startdate, dos, oos);
					
						writeDate(this.enddate, dos, oos);
					
						writeString(this.status, dos, oos);
					
		            	dos.writeInt(this.citykey);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.userid);
					
						writeString(this.first_name, dos, objectOut);
					
						writeString(this.last_name, dos, objectOut);
					
						writeString(this.gender, dos, objectOut);
					
						writeString(this.subscriptiontype, dos, objectOut);
					
						writeDate(this.startdate, dos, objectOut);
					
						writeDate(this.enddate, dos, objectOut);
					
						writeString(this.status, dos, objectOut);
					
					objectOut.writeInt(this.citykey);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("userkey="+String.valueOf(userkey));
		sb.append(",userid="+String.valueOf(userid));
		sb.append(",first_name="+first_name);
		sb.append(",last_name="+last_name);
		sb.append(",gender="+gender);
		sb.append(",subscriptiontype="+subscriptiontype);
		sb.append(",startdate="+String.valueOf(startdate));
		sb.append(",enddate="+String.valueOf(enddate));
		sb.append(",status="+status);
		sb.append(",citykey="+String.valueOf(citykey));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				sb.append(userkey);
        			
        			sb.append("|");
        		
        				sb.append(userid);
        			
        			sb.append("|");
        		
        				if(first_name == null){
        					sb.append("<null>");
        				}else{
            				sb.append(first_name);
            			}
            		
        			sb.append("|");
        		
        				if(last_name == null){
        					sb.append("<null>");
        				}else{
            				sb.append(last_name);
            			}
            		
        			sb.append("|");
        		
        				if(gender == null){
        					sb.append("<null>");
        				}else{
            				sb.append(gender);
            			}
            		
        			sb.append("|");
        		
        				if(subscriptiontype == null){
        					sb.append("<null>");
        				}else{
            				sb.append(subscriptiontype);
            			}
            		
        			sb.append("|");
        		
        				if(startdate == null){
        					sb.append("<null>");
        				}else{
            				sb.append(startdate);
            			}
            		
        			sb.append("|");
        		
        				if(enddate == null){
        					sb.append("<null>");
        				}else{
            				sb.append(enddate);
            			}
            		
        			sb.append("|");
        		
        				if(status == null){
        					sb.append("<null>");
        				}else{
            				sb.append(status);
            			}
            		
        			sb.append("|");
        		
        				sb.append(citykey);
        			
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.userkey, other.userkey);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_4_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row2Struct row2 = new row2Struct();




	
	/**
	 * [tAdvancedHash_row2 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row2", false);
		start_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row2";

	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row2");
			
		int tos_count_tAdvancedHash_row2 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tAdvancedHash_row2", "tAdvancedHash_row2", "tAdvancedHash");
				talendJobLogProcess(globalMap);
			}
			

			   		// connection name:row2
			   		// source node:tDBInput_4 - inputs:(after_tDBInput_1) outputs:(row2,row2) | target node:tAdvancedHash_row2 - inputs:(row2) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2,row3,row7,row8) outputs:(Found1,NotFound1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row2 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row2Struct>getLookup(matchingModeEnum_row2);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row2", tHash_Lookup_row2);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row2 begin ] stop
 */



	
	/**
	 * [tDBInput_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_4", false);
		start_Hash.put("tDBInput_4", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_4";

	
		int tos_count_tDBInput_4 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBInput_4 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBInput_4{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBInput_4 = new StringBuilder();
                    log4jParamters_tDBInput_4.append("Parameters:");
                            log4jParamters_tDBInput_4.append("USE_EXISTING_CONNECTION" + " = " + "true");
                        log4jParamters_tDBInput_4.append(" | ");
                            log4jParamters_tDBInput_4.append("CONNECTION" + " = " + "tDBConnection_2");
                        log4jParamters_tDBInput_4.append(" | ");
                            log4jParamters_tDBInput_4.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_4.append(" | ");
                            log4jParamters_tDBInput_4.append("QUERY" + " = " + "\"SELECT * FROM USERSDIM;\"");
                        log4jParamters_tDBInput_4.append(" | ");
                            log4jParamters_tDBInput_4.append("USE_CURSOR" + " = " + "false");
                        log4jParamters_tDBInput_4.append(" | ");
                            log4jParamters_tDBInput_4.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_4.append(" | ");
                            log4jParamters_tDBInput_4.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("userkey")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("userid")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("first_name")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("last_name")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("gender")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("subscriptiontype")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("startdate")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("enddate")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("status")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("citykey")+"}]");
                        log4jParamters_tDBInput_4.append(" | ");
                            log4jParamters_tDBInput_4.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlInput");
                        log4jParamters_tDBInput_4.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBInput_4 - "  + (log4jParamters_tDBInput_4) );
                    } 
                } 
            new BytesLimit65535_tDBInput_4().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBInput_4", "__TABLE__", "tPostgresqlInput");
				talendJobLogProcess(globalMap);
			}
			
	
    
	
		    int nb_line_tDBInput_4 = 0;
		    java.sql.Connection conn_tDBInput_4 = null;
				conn_tDBInput_4 = (java.sql.Connection)globalMap.get("conn_tDBConnection_2");
				
				if(conn_tDBInput_4 != null) {
					if(conn_tDBInput_4.getMetaData() != null) {
						
							log.debug("tDBInput_4 - Uses an existing connection with username '" + conn_tDBInput_4.getMetaData().getUserName() + "'. Connection URL: " + conn_tDBInput_4.getMetaData().getURL() + ".");
						
					}
				}
			
		    
			java.sql.Statement stmt_tDBInput_4 = conn_tDBInput_4.createStatement();

		    String dbquery_tDBInput_4 = "SELECT * FROM USERSDIM;";
		    
	    		log.debug("tDBInput_4 - Executing the query: '" + dbquery_tDBInput_4 + "'.");
			

            	globalMap.put("tDBInput_4_QUERY",dbquery_tDBInput_4);
		    java.sql.ResultSet rs_tDBInput_4 = null;

		    try {
		    	rs_tDBInput_4 = stmt_tDBInput_4.executeQuery(dbquery_tDBInput_4);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_4 = rs_tDBInput_4.getMetaData();
		    	int colQtyInRs_tDBInput_4 = rsmd_tDBInput_4.getColumnCount();

		    String tmpContent_tDBInput_4 = null;
		    
		    
		    	log.debug("tDBInput_4 - Retrieving records from the database.");
		    
		    while (rs_tDBInput_4.next()) {
		        nb_line_tDBInput_4++;
		        
							if(colQtyInRs_tDBInput_4 < 1) {
								row2.userkey = 0;
							} else {
		                          
            row2.userkey = rs_tDBInput_4.getInt(1);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 2) {
								row2.userid = 0;
							} else {
		                          
            row2.userid = rs_tDBInput_4.getInt(2);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 3) {
								row2.first_name = null;
							} else {
	                         		
        	row2.first_name = routines.system.JDBCUtil.getString(rs_tDBInput_4, 3, false);
		                    }
							if(colQtyInRs_tDBInput_4 < 4) {
								row2.last_name = null;
							} else {
	                         		
        	row2.last_name = routines.system.JDBCUtil.getString(rs_tDBInput_4, 4, false);
		                    }
							if(colQtyInRs_tDBInput_4 < 5) {
								row2.gender = null;
							} else {
	                         		
        	row2.gender = routines.system.JDBCUtil.getString(rs_tDBInput_4, 5, false);
		                    }
							if(colQtyInRs_tDBInput_4 < 6) {
								row2.subscriptiontype = null;
							} else {
	                         		
        	row2.subscriptiontype = routines.system.JDBCUtil.getString(rs_tDBInput_4, 6, false);
		                    }
							if(colQtyInRs_tDBInput_4 < 7) {
								row2.startdate = null;
							} else {
										
			row2.startdate = routines.system.JDBCUtil.getDate(rs_tDBInput_4, 7);
		                    }
							if(colQtyInRs_tDBInput_4 < 8) {
								row2.enddate = null;
							} else {
										
			row2.enddate = routines.system.JDBCUtil.getDate(rs_tDBInput_4, 8);
		                    }
							if(colQtyInRs_tDBInput_4 < 9) {
								row2.status = null;
							} else {
	                         		
        	row2.status = routines.system.JDBCUtil.getString(rs_tDBInput_4, 9, false);
		                    }
							if(colQtyInRs_tDBInput_4 < 10) {
								row2.citykey = 0;
							} else {
		                          
            row2.citykey = rs_tDBInput_4.getInt(10);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
					
						log.debug("tDBInput_4 - Retrieving the record " + nb_line_tDBInput_4 + ".");
					


 



/**
 * [tDBInput_4 begin ] stop
 */
	
	/**
	 * [tDBInput_4 main ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 


	tos_count_tDBInput_4++;

/**
 * [tDBInput_4 main ] stop
 */
	
	/**
	 * [tDBInput_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row2","tDBInput_4","__TABLE__","tPostgresqlInput","tAdvancedHash_row2","tAdvancedHash_row2","tAdvancedHash"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row2 - " + (row2==null? "": row2.toLogString()));
    			}
    		


			   
			   

					row2Struct row2_HashRow = new row2Struct();
		   	   	   
				
				row2_HashRow.userkey = row2.userkey;
				
				row2_HashRow.userid = row2.userid;
				
				row2_HashRow.first_name = row2.first_name;
				
				row2_HashRow.last_name = row2.last_name;
				
				row2_HashRow.gender = row2.gender;
				
				row2_HashRow.subscriptiontype = row2.subscriptiontype;
				
				row2_HashRow.startdate = row2.startdate;
				
				row2_HashRow.enddate = row2.enddate;
				
				row2_HashRow.status = row2.status;
				
				row2_HashRow.citykey = row2.citykey;
				
			tHash_Lookup_row2.put(row2_HashRow);
			
            




 


	tos_count_tAdvancedHash_row2++;

/**
 * [tAdvancedHash_row2 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row2 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_4 end ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

	}
}finally{
	if (rs_tDBInput_4 != null) {
		rs_tDBInput_4.close();
	}
	if (stmt_tDBInput_4 != null) {
		stmt_tDBInput_4.close();
	}
}
globalMap.put("tDBInput_4_NB_LINE",nb_line_tDBInput_4);
	    		log.debug("tDBInput_4 - Retrieved records count: "+nb_line_tDBInput_4 + " .");
			
 
                if(log.isDebugEnabled())
            log.debug("tDBInput_4 - "  + ("Done.") );

ok_Hash.put("tDBInput_4", true);
end_Hash.put("tDBInput_4", System.currentTimeMillis());




/**
 * [tDBInput_4 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

tHash_Lookup_row2.endPut();

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row2",2,0,
			 			"tDBInput_4","__TABLE__","tPostgresqlInput","tAdvancedHash_row2","tAdvancedHash_row2","tAdvancedHash","output")) {
						talendJobLogProcess(globalMap);
					}
				
 

ok_Hash.put("tAdvancedHash_row2", true);
end_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());




/**
 * [tAdvancedHash_row2 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_4 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 1);
	}
	


public static class row3Struct implements routines.system.IPersistableComparableLookupRow<row3Struct> {
    final static byte[] commonByteArrayLock_ARTISTLOC_FactTable = new byte[0];
    static byte[] commonByteArray_ARTISTLOC_FactTable = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int songkey;

				public int getSongkey () {
					return this.songkey;
				}
				
			    public Integer songid;

				public Integer getSongid () {
					return this.songid;
				}
				
			    public String songtitle;

				public String getSongtitle () {
					return this.songtitle;
				}
				
			    public BigDecimal songduration;

				public BigDecimal getSongduration () {
					return this.songduration;
				}
				
			    public int releaseyear;

				public int getReleaseyear () {
					return this.releaseyear;
				}
				
			    public int artistkey;

				public int getArtistkey () {
					return this.artistkey;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.songkey;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row3Struct other = (row3Struct) obj;
		
						if (this.songkey != other.songkey)
							return false;
					

		return true;
    }

	public void copyDataTo(row3Struct other) {

		other.songkey = this.songkey;
	            other.songid = this.songid;
	            other.songtitle = this.songtitle;
	            other.songduration = this.songduration;
	            other.releaseyear = this.releaseyear;
	            other.artistkey = this.artistkey;
	            
	}

	public void copyKeysDataTo(row3Struct other) {

		other.songkey = this.songkey;
	            	
	}



	private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		Integer intReturn;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = unmarshaller.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, DataOutputStream dos,org.jboss.marshalling.Marshaller marshaller ) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}
	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ARTISTLOC_FactTable) {

        	try {

        		int length = 0;
		
			        this.songkey = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ARTISTLOC_FactTable) {

        	try {

        		int length = 0;
		
			        this.songkey = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.songkey);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.songkey);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
						this.songid = readInteger(dis,ois);
					
						this.songtitle = readString(dis,ois);
					
       			    	this.songduration = (BigDecimal) ois.readObject();
					
			            this.releaseyear = dis.readInt();
					
			            this.artistkey = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.songid = readInteger(dis,objectIn);
					
						this.songtitle = readString(dis,objectIn);
					
       			    	this.songduration = (BigDecimal) objectIn.readObject();
					
			            this.releaseyear = objectIn.readInt();
					
			            this.artistkey = objectIn.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
					writeInteger(this.songid, dos, oos);
					
						writeString(this.songtitle, dos, oos);
					
       			    	oos.writeObject(this.songduration);
					
		            	dos.writeInt(this.releaseyear);
					
		            	dos.writeInt(this.artistkey);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					writeInteger(this.songid, dos, objectOut);
					
						writeString(this.songtitle, dos, objectOut);
					
       			    	objectOut.writeObject(this.songduration);
					
					objectOut.writeInt(this.releaseyear);
					
					objectOut.writeInt(this.artistkey);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("songkey="+String.valueOf(songkey));
		sb.append(",songid="+String.valueOf(songid));
		sb.append(",songtitle="+songtitle);
		sb.append(",songduration="+String.valueOf(songduration));
		sb.append(",releaseyear="+String.valueOf(releaseyear));
		sb.append(",artistkey="+String.valueOf(artistkey));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				sb.append(songkey);
        			
        			sb.append("|");
        		
        				if(songid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(songid);
            			}
            		
        			sb.append("|");
        		
        				if(songtitle == null){
        					sb.append("<null>");
        				}else{
            				sb.append(songtitle);
            			}
            		
        			sb.append("|");
        		
        				if(songduration == null){
        					sb.append("<null>");
        				}else{
            				sb.append(songduration);
            			}
            		
        			sb.append("|");
        		
        				sb.append(releaseyear);
        			
        			sb.append("|");
        		
        				sb.append(artistkey);
        			
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.songkey, other.songkey);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_7Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_7_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row3Struct row3 = new row3Struct();




	
	/**
	 * [tAdvancedHash_row3 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row3", false);
		start_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row3";

	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row3");
			
		int tos_count_tAdvancedHash_row3 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tAdvancedHash_row3", "tAdvancedHash_row3", "tAdvancedHash");
				talendJobLogProcess(globalMap);
			}
			

			   		// connection name:row3
			   		// source node:tDBInput_7 - inputs:(after_tDBInput_1) outputs:(row3,row3) | target node:tAdvancedHash_row3 - inputs:(row3) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2,row3,row7,row8) outputs:(Found1,NotFound1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row3 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row3Struct>getLookup(matchingModeEnum_row3);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row3", tHash_Lookup_row3);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row3 begin ] stop
 */



	
	/**
	 * [tDBInput_7 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_7", false);
		start_Hash.put("tDBInput_7", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_7";

	
		int tos_count_tDBInput_7 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBInput_7 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBInput_7{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBInput_7 = new StringBuilder();
                    log4jParamters_tDBInput_7.append("Parameters:");
                            log4jParamters_tDBInput_7.append("USE_EXISTING_CONNECTION" + " = " + "true");
                        log4jParamters_tDBInput_7.append(" | ");
                            log4jParamters_tDBInput_7.append("CONNECTION" + " = " + "tDBConnection_2");
                        log4jParamters_tDBInput_7.append(" | ");
                            log4jParamters_tDBInput_7.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_7.append(" | ");
                            log4jParamters_tDBInput_7.append("QUERY" + " = " + "\"SELECT * FROM SONGSDIM;\"");
                        log4jParamters_tDBInput_7.append(" | ");
                            log4jParamters_tDBInput_7.append("USE_CURSOR" + " = " + "false");
                        log4jParamters_tDBInput_7.append(" | ");
                            log4jParamters_tDBInput_7.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_7.append(" | ");
                            log4jParamters_tDBInput_7.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("songkey")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("songid")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("songtitle")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("songduration")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("releaseyear")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("artistkey")+"}]");
                        log4jParamters_tDBInput_7.append(" | ");
                            log4jParamters_tDBInput_7.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlInput");
                        log4jParamters_tDBInput_7.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBInput_7 - "  + (log4jParamters_tDBInput_7) );
                    } 
                } 
            new BytesLimit65535_tDBInput_7().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBInput_7", "__TABLE__", "tPostgresqlInput");
				talendJobLogProcess(globalMap);
			}
			
	
    
	
		    int nb_line_tDBInput_7 = 0;
		    java.sql.Connection conn_tDBInput_7 = null;
				conn_tDBInput_7 = (java.sql.Connection)globalMap.get("conn_tDBConnection_2");
				
				if(conn_tDBInput_7 != null) {
					if(conn_tDBInput_7.getMetaData() != null) {
						
							log.debug("tDBInput_7 - Uses an existing connection with username '" + conn_tDBInput_7.getMetaData().getUserName() + "'. Connection URL: " + conn_tDBInput_7.getMetaData().getURL() + ".");
						
					}
				}
			
		    
			java.sql.Statement stmt_tDBInput_7 = conn_tDBInput_7.createStatement();

		    String dbquery_tDBInput_7 = "SELECT * FROM SONGSDIM;";
		    
	    		log.debug("tDBInput_7 - Executing the query: '" + dbquery_tDBInput_7 + "'.");
			

            	globalMap.put("tDBInput_7_QUERY",dbquery_tDBInput_7);
		    java.sql.ResultSet rs_tDBInput_7 = null;

		    try {
		    	rs_tDBInput_7 = stmt_tDBInput_7.executeQuery(dbquery_tDBInput_7);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_7 = rs_tDBInput_7.getMetaData();
		    	int colQtyInRs_tDBInput_7 = rsmd_tDBInput_7.getColumnCount();

		    String tmpContent_tDBInput_7 = null;
		    
		    
		    	log.debug("tDBInput_7 - Retrieving records from the database.");
		    
		    while (rs_tDBInput_7.next()) {
		        nb_line_tDBInput_7++;
		        
							if(colQtyInRs_tDBInput_7 < 1) {
								row3.songkey = 0;
							} else {
		                          
            row3.songkey = rs_tDBInput_7.getInt(1);
            if(rs_tDBInput_7.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_7 < 2) {
								row3.songid = null;
							} else {
		                          
            row3.songid = rs_tDBInput_7.getInt(2);
            if(rs_tDBInput_7.wasNull()){
                    row3.songid = null;
            }
		                    }
							if(colQtyInRs_tDBInput_7 < 3) {
								row3.songtitle = null;
							} else {
	                         		
        	row3.songtitle = routines.system.JDBCUtil.getString(rs_tDBInput_7, 3, false);
		                    }
							if(colQtyInRs_tDBInput_7 < 4) {
								row3.songduration = null;
							} else {
		                          
            row3.songduration = rs_tDBInput_7.getBigDecimal(4);
            if(rs_tDBInput_7.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_7 < 5) {
								row3.releaseyear = 0;
							} else {
		                          
            row3.releaseyear = rs_tDBInput_7.getInt(5);
            if(rs_tDBInput_7.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_7 < 6) {
								row3.artistkey = 0;
							} else {
		                          
            row3.artistkey = rs_tDBInput_7.getInt(6);
            if(rs_tDBInput_7.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
					
						log.debug("tDBInput_7 - Retrieving the record " + nb_line_tDBInput_7 + ".");
					


 



/**
 * [tDBInput_7 begin ] stop
 */
	
	/**
	 * [tDBInput_7 main ] start
	 */

	

	
	
	currentComponent="tDBInput_7";

	

 


	tos_count_tDBInput_7++;

/**
 * [tDBInput_7 main ] stop
 */
	
	/**
	 * [tDBInput_7 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_7";

	

 



/**
 * [tDBInput_7 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row3 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row3","tDBInput_7","__TABLE__","tPostgresqlInput","tAdvancedHash_row3","tAdvancedHash_row3","tAdvancedHash"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row3 - " + (row3==null? "": row3.toLogString()));
    			}
    		


			   
			   

					row3Struct row3_HashRow = new row3Struct();
		   	   	   
				
				row3_HashRow.songkey = row3.songkey;
				
				row3_HashRow.songid = row3.songid;
				
				row3_HashRow.songtitle = row3.songtitle;
				
				row3_HashRow.songduration = row3.songduration;
				
				row3_HashRow.releaseyear = row3.releaseyear;
				
				row3_HashRow.artistkey = row3.artistkey;
				
			tHash_Lookup_row3.put(row3_HashRow);
			
            




 


	tos_count_tAdvancedHash_row3++;

/**
 * [tAdvancedHash_row3 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

 



/**
 * [tAdvancedHash_row3 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row3 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

 



/**
 * [tAdvancedHash_row3 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_7 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_7";

	

 



/**
 * [tDBInput_7 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_7 end ] start
	 */

	

	
	
	currentComponent="tDBInput_7";

	

	}
}finally{
	if (rs_tDBInput_7 != null) {
		rs_tDBInput_7.close();
	}
	if (stmt_tDBInput_7 != null) {
		stmt_tDBInput_7.close();
	}
}
globalMap.put("tDBInput_7_NB_LINE",nb_line_tDBInput_7);
	    		log.debug("tDBInput_7 - Retrieved records count: "+nb_line_tDBInput_7 + " .");
			
 
                if(log.isDebugEnabled())
            log.debug("tDBInput_7 - "  + ("Done.") );

ok_Hash.put("tDBInput_7", true);
end_Hash.put("tDBInput_7", System.currentTimeMillis());




/**
 * [tDBInput_7 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row3 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

tHash_Lookup_row3.endPut();

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row3",2,0,
			 			"tDBInput_7","__TABLE__","tPostgresqlInput","tAdvancedHash_row3","tAdvancedHash_row3","tAdvancedHash","output")) {
						talendJobLogProcess(globalMap);
					}
				
 

ok_Hash.put("tAdvancedHash_row3", true);
end_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());




/**
 * [tAdvancedHash_row3 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_7 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_7";

	

 



/**
 * [tDBInput_7 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row3 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

 



/**
 * [tAdvancedHash_row3 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_7_SUBPROCESS_STATE", 1);
	}
	


public static class row7Struct implements routines.system.IPersistableComparableLookupRow<row7Struct> {
    final static byte[] commonByteArrayLock_ARTISTLOC_FactTable = new byte[0];
    static byte[] commonByteArray_ARTISTLOC_FactTable = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int listening_activity_key;

				public int getListening_activity_key () {
					return this.listening_activity_key;
				}
				
			    public int user_key;

				public int getUser_key () {
					return this.user_key;
				}
				
			    public int session_key;

				public int getSession_key () {
					return this.session_key;
				}
				
			    public int artist_key;

				public int getArtist_key () {
					return this.artist_key;
				}
				
			    public int song_key;

				public int getSong_key () {
					return this.song_key;
				}
				
			    public BigDecimal total_sesssion_duration;

				public BigDecimal getTotal_sesssion_duration () {
					return this.total_sesssion_duration;
				}
				
			    public int subscription_type;

				public int getSubscription_type () {
					return this.subscription_type;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.user_key;
						
							result = prime * result + (int) this.session_key;
						
							result = prime * result + (int) this.artist_key;
						
							result = prime * result + (int) this.song_key;
						
						result = prime * result + ((this.total_sesssion_duration == null) ? 0 : new Double(this.total_sesssion_duration.doubleValue()).hashCode());
						
							result = prime * result + (int) this.subscription_type;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row7Struct other = (row7Struct) obj;
		
						if (this.user_key != other.user_key)
							return false;
					
						if (this.session_key != other.session_key)
							return false;
					
						if (this.artist_key != other.artist_key)
							return false;
					
						if (this.song_key != other.song_key)
							return false;
					
						if (this.total_sesssion_duration == null) {
							if (other.total_sesssion_duration != null)
								return false;
						
						} else if ((other.total_sesssion_duration == null) || (this.total_sesssion_duration.compareTo(other.total_sesssion_duration)!=0))
						
							return false;
					
						if (this.subscription_type != other.subscription_type)
							return false;
					

		return true;
    }

	public void copyDataTo(row7Struct other) {

		other.listening_activity_key = this.listening_activity_key;
	            other.user_key = this.user_key;
	            other.session_key = this.session_key;
	            other.artist_key = this.artist_key;
	            other.song_key = this.song_key;
	            other.total_sesssion_duration = this.total_sesssion_duration;
	            other.subscription_type = this.subscription_type;
	            
	}

	public void copyKeysDataTo(row7Struct other) {

		other.user_key = this.user_key;
	            	other.session_key = this.session_key;
	            	other.artist_key = this.artist_key;
	            	other.song_key = this.song_key;
	            	other.total_sesssion_duration = this.total_sesssion_duration;
	            	other.subscription_type = this.subscription_type;
	            	
	}




    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ARTISTLOC_FactTable) {

        	try {

        		int length = 0;
		
			        this.user_key = dis.readInt();
					
			        this.session_key = dis.readInt();
					
			        this.artist_key = dis.readInt();
					
			        this.song_key = dis.readInt();
					
						this.total_sesssion_duration = (BigDecimal) dis.readObject();
					
			        this.subscription_type = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ARTISTLOC_FactTable) {

        	try {

        		int length = 0;
		
			        this.user_key = dis.readInt();
					
			        this.session_key = dis.readInt();
					
			        this.artist_key = dis.readInt();
					
			        this.song_key = dis.readInt();
					
						this.total_sesssion_duration = (BigDecimal) dis.readObject();
					
			        this.subscription_type = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.user_key);
					
					// int
				
		            	dos.writeInt(this.session_key);
					
					// int
				
		            	dos.writeInt(this.artist_key);
					
					// int
				
		            	dos.writeInt(this.song_key);
					
					// BigDecimal
				
       			    	dos.writeObject(this.total_sesssion_duration);
					
					// int
				
		            	dos.writeInt(this.subscription_type);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.user_key);
					
					// int
				
		            	dos.writeInt(this.session_key);
					
					// int
				
		            	dos.writeInt(this.artist_key);
					
					// int
				
		            	dos.writeInt(this.song_key);
					
					// BigDecimal
				
       			    	dos.writeObject(this.total_sesssion_duration);
					
					// int
				
		            	dos.writeInt(this.subscription_type);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
			            this.listening_activity_key = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.listening_activity_key = objectIn.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.listening_activity_key);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.listening_activity_key);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("listening_activity_key="+String.valueOf(listening_activity_key));
		sb.append(",user_key="+String.valueOf(user_key));
		sb.append(",session_key="+String.valueOf(session_key));
		sb.append(",artist_key="+String.valueOf(artist_key));
		sb.append(",song_key="+String.valueOf(song_key));
		sb.append(",total_sesssion_duration="+String.valueOf(total_sesssion_duration));
		sb.append(",subscription_type="+String.valueOf(subscription_type));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				sb.append(listening_activity_key);
        			
        			sb.append("|");
        		
        				sb.append(user_key);
        			
        			sb.append("|");
        		
        				sb.append(session_key);
        			
        			sb.append("|");
        		
        				sb.append(artist_key);
        			
        			sb.append("|");
        		
        				sb.append(song_key);
        			
        			sb.append("|");
        		
        				if(total_sesssion_duration == null){
        					sb.append("<null>");
        				}else{
            				sb.append(total_sesssion_duration);
            			}
            		
        			sb.append("|");
        		
        				sb.append(subscription_type);
        			
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row7Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.user_key, other.user_key);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.session_key, other.session_key);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.artist_key, other.artist_key);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.song_key, other.song_key);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.total_sesssion_duration, other.total_sesssion_duration);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.subscription_type, other.subscription_type);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row7Struct row7 = new row7Struct();




	
	/**
	 * [tAdvancedHash_row7 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row7", false);
		start_Hash.put("tAdvancedHash_row7", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row7";

	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row7");
			
		int tos_count_tAdvancedHash_row7 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tAdvancedHash_row7", "tAdvancedHash_row7", "tAdvancedHash");
				talendJobLogProcess(globalMap);
			}
			

			   		// connection name:row7
			   		// source node:tDBInput_2 - inputs:(after_tDBInput_1) outputs:(row7,row7) | target node:tAdvancedHash_row7 - inputs:(row7) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2,row3,row7,row8) outputs:(Found1,NotFound1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row7 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row7Struct> tHash_Lookup_row7 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row7Struct>getLookup(matchingModeEnum_row7);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row7", tHash_Lookup_row7);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row7 begin ] stop
 */



	
	/**
	 * [tDBInput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_2", false);
		start_Hash.put("tDBInput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_2";

	
		int tos_count_tDBInput_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBInput_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBInput_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBInput_2 = new StringBuilder();
                    log4jParamters_tDBInput_2.append("Parameters:");
                            log4jParamters_tDBInput_2.append("USE_EXISTING_CONNECTION" + " = " + "true");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("CONNECTION" + " = " + "tDBConnection_2");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("QUERY" + " = " + "\"SELECT * FROM LISTENING_ACTIVITY;\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("USE_CURSOR" + " = " + "false");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("listening_activity_key")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("user_key")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("session_key")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("artist_key")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("song_key")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("total_sesssion_duration")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("subscription_type")+"}]");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlInput");
                        log4jParamters_tDBInput_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBInput_2 - "  + (log4jParamters_tDBInput_2) );
                    } 
                } 
            new BytesLimit65535_tDBInput_2().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBInput_2", "__TABLE__", "tPostgresqlInput");
				talendJobLogProcess(globalMap);
			}
			
	
    
	
		    int nb_line_tDBInput_2 = 0;
		    java.sql.Connection conn_tDBInput_2 = null;
				conn_tDBInput_2 = (java.sql.Connection)globalMap.get("conn_tDBConnection_2");
				
				if(conn_tDBInput_2 != null) {
					if(conn_tDBInput_2.getMetaData() != null) {
						
							log.debug("tDBInput_2 - Uses an existing connection with username '" + conn_tDBInput_2.getMetaData().getUserName() + "'. Connection URL: " + conn_tDBInput_2.getMetaData().getURL() + ".");
						
					}
				}
			
		    
			java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

		    String dbquery_tDBInput_2 = "SELECT * FROM LISTENING_ACTIVITY;";
		    
	    		log.debug("tDBInput_2 - Executing the query: '" + dbquery_tDBInput_2 + "'.");
			

            	globalMap.put("tDBInput_2_QUERY",dbquery_tDBInput_2);
		    java.sql.ResultSet rs_tDBInput_2 = null;

		    try {
		    	rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
		    	int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

		    String tmpContent_tDBInput_2 = null;
		    
		    
		    	log.debug("tDBInput_2 - Retrieving records from the database.");
		    
		    while (rs_tDBInput_2.next()) {
		        nb_line_tDBInput_2++;
		        
							if(colQtyInRs_tDBInput_2 < 1) {
								row7.listening_activity_key = 0;
							} else {
		                          
            row7.listening_activity_key = rs_tDBInput_2.getInt(1);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								row7.user_key = 0;
							} else {
		                          
            row7.user_key = rs_tDBInput_2.getInt(2);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								row7.session_key = 0;
							} else {
		                          
            row7.session_key = rs_tDBInput_2.getInt(3);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								row7.artist_key = 0;
							} else {
		                          
            row7.artist_key = rs_tDBInput_2.getInt(4);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								row7.song_key = 0;
							} else {
		                          
            row7.song_key = rs_tDBInput_2.getInt(5);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 6) {
								row7.total_sesssion_duration = null;
							} else {
		                          
            row7.total_sesssion_duration = rs_tDBInput_2.getBigDecimal(6);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 7) {
								row7.subscription_type = 0;
							} else {
		                          
            row7.subscription_type = rs_tDBInput_2.getInt(7);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
					
						log.debug("tDBInput_2 - Retrieving the record " + nb_line_tDBInput_2 + ".");
					


 



/**
 * [tDBInput_2 begin ] stop
 */
	
	/**
	 * [tDBInput_2 main ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 


	tos_count_tDBInput_2++;

/**
 * [tDBInput_2 main ] stop
 */
	
	/**
	 * [tDBInput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row7 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row7";

	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row7","tDBInput_2","__TABLE__","tPostgresqlInput","tAdvancedHash_row7","tAdvancedHash_row7","tAdvancedHash"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row7 - " + (row7==null? "": row7.toLogString()));
    			}
    		


			   
			   

					row7Struct row7_HashRow = new row7Struct();
		   	   	   
				
				row7_HashRow.listening_activity_key = row7.listening_activity_key;
				
				row7_HashRow.user_key = row7.user_key;
				
				row7_HashRow.session_key = row7.session_key;
				
				row7_HashRow.artist_key = row7.artist_key;
				
				row7_HashRow.song_key = row7.song_key;
				
				row7_HashRow.total_sesssion_duration = row7.total_sesssion_duration;
				
				row7_HashRow.subscription_type = row7.subscription_type;
				
			tHash_Lookup_row7.put(row7_HashRow);
			
            




 


	tos_count_tAdvancedHash_row7++;

/**
 * [tAdvancedHash_row7 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row7 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row7";

	

 



/**
 * [tAdvancedHash_row7 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row7 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row7";

	

 



/**
 * [tAdvancedHash_row7 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_2 end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

	}
}finally{
	if (rs_tDBInput_2 != null) {
		rs_tDBInput_2.close();
	}
	if (stmt_tDBInput_2 != null) {
		stmt_tDBInput_2.close();
	}
}
globalMap.put("tDBInput_2_NB_LINE",nb_line_tDBInput_2);
	    		log.debug("tDBInput_2 - Retrieved records count: "+nb_line_tDBInput_2 + " .");
			
 
                if(log.isDebugEnabled())
            log.debug("tDBInput_2 - "  + ("Done.") );

ok_Hash.put("tDBInput_2", true);
end_Hash.put("tDBInput_2", System.currentTimeMillis());




/**
 * [tDBInput_2 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row7 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row7";

	

tHash_Lookup_row7.endPut();

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row7",2,0,
			 			"tDBInput_2","__TABLE__","tPostgresqlInput","tAdvancedHash_row7","tAdvancedHash_row7","tAdvancedHash","output")) {
						talendJobLogProcess(globalMap);
					}
				
 

ok_Hash.put("tAdvancedHash_row7", true);
end_Hash.put("tAdvancedHash_row7", System.currentTimeMillis());




/**
 * [tAdvancedHash_row7 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row7 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row7";

	

 



/**
 * [tAdvancedHash_row7 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}
	


public static class row8Struct implements routines.system.IPersistableComparableLookupRow<row8Struct> {
    final static byte[] commonByteArrayLock_ARTISTLOC_FactTable = new byte[0];
    static byte[] commonByteArray_ARTISTLOC_FactTable = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int artistkey;

				public int getArtistkey () {
					return this.artistkey;
				}
				
			    public String artistid;

				public String getArtistid () {
					return this.artistid;
				}
				
			    public String artistname;

				public String getArtistname () {
					return this.artistname;
				}
				
			    public int citykey;

				public int getCitykey () {
					return this.citykey;
				}
				
			    public java.util.Date startdate;

				public java.util.Date getStartdate () {
					return this.startdate;
				}
				
			    public java.util.Date enddate;

				public java.util.Date getEnddate () {
					return this.enddate;
				}
				
			    public String status_flag;

				public String getStatus_flag () {
					return this.status_flag;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.artistkey;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row8Struct other = (row8Struct) obj;
		
						if (this.artistkey != other.artistkey)
							return false;
					

		return true;
    }

	public void copyDataTo(row8Struct other) {

		other.artistkey = this.artistkey;
	            other.artistid = this.artistid;
	            other.artistname = this.artistname;
	            other.citykey = this.citykey;
	            other.startdate = this.startdate;
	            other.enddate = this.enddate;
	            other.status_flag = this.status_flag;
	            
	}

	public void copyKeysDataTo(row8Struct other) {

		other.artistkey = this.artistkey;
	            	
	}



	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

	private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller ) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

	private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
	}
	
	private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ARTISTLOC_FactTable) {

        	try {

        		int length = 0;
		
			        this.artistkey = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ARTISTLOC_FactTable) {

        	try {

        		int length = 0;
		
			        this.artistkey = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.artistkey);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.artistkey);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
						this.artistid = readString(dis,ois);
					
						this.artistname = readString(dis,ois);
					
			            this.citykey = dis.readInt();
					
						this.startdate = readDate(dis,ois);
					
						this.enddate = readDate(dis,ois);
					
						this.status_flag = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.artistid = readString(dis,objectIn);
					
						this.artistname = readString(dis,objectIn);
					
			            this.citykey = objectIn.readInt();
					
						this.startdate = readDate(dis,objectIn);
					
						this.enddate = readDate(dis,objectIn);
					
						this.status_flag = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.artistid, dos, oos);
					
						writeString(this.artistname, dos, oos);
					
		            	dos.writeInt(this.citykey);
					
						writeDate(this.startdate, dos, oos);
					
						writeDate(this.enddate, dos, oos);
					
						writeString(this.status_flag, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.artistid, dos, objectOut);
					
						writeString(this.artistname, dos, objectOut);
					
					objectOut.writeInt(this.citykey);
					
						writeDate(this.startdate, dos, objectOut);
					
						writeDate(this.enddate, dos, objectOut);
					
						writeString(this.status_flag, dos, objectOut);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("artistkey="+String.valueOf(artistkey));
		sb.append(",artistid="+artistid);
		sb.append(",artistname="+artistname);
		sb.append(",citykey="+String.valueOf(citykey));
		sb.append(",startdate="+String.valueOf(startdate));
		sb.append(",enddate="+String.valueOf(enddate));
		sb.append(",status_flag="+status_flag);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				sb.append(artistkey);
        			
        			sb.append("|");
        		
        				if(artistid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(artistid);
            			}
            		
        			sb.append("|");
        		
        				if(artistname == null){
        					sb.append("<null>");
        				}else{
            				sb.append(artistname);
            			}
            		
        			sb.append("|");
        		
        				sb.append(citykey);
        			
        			sb.append("|");
        		
        				if(startdate == null){
        					sb.append("<null>");
        				}else{
            				sb.append(startdate);
            			}
            		
        			sb.append("|");
        		
        				if(enddate == null){
        					sb.append("<null>");
        				}else{
            				sb.append(enddate);
            			}
            		
        			sb.append("|");
        		
        				if(status_flag == null){
        					sb.append("<null>");
        				}else{
            				sb.append(status_flag);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row8Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.artistkey, other.artistkey);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_8Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_8_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row8Struct row8 = new row8Struct();




	
	/**
	 * [tAdvancedHash_row8 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row8", false);
		start_Hash.put("tAdvancedHash_row8", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row8";

	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row8");
			
		int tos_count_tAdvancedHash_row8 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tAdvancedHash_row8", "tAdvancedHash_row8", "tAdvancedHash");
				talendJobLogProcess(globalMap);
			}
			

			   		// connection name:row8
			   		// source node:tDBInput_8 - inputs:(after_tDBInput_1) outputs:(row8,row8) | target node:tAdvancedHash_row8 - inputs:(row8) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2,row3,row7,row8) outputs:(Found1,NotFound1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row8 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row8Struct> tHash_Lookup_row8 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row8Struct>getLookup(matchingModeEnum_row8);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row8", tHash_Lookup_row8);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row8 begin ] stop
 */



	
	/**
	 * [tDBInput_8 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_8", false);
		start_Hash.put("tDBInput_8", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_8";

	
		int tos_count_tDBInput_8 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBInput_8 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBInput_8{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBInput_8 = new StringBuilder();
                    log4jParamters_tDBInput_8.append("Parameters:");
                            log4jParamters_tDBInput_8.append("USE_EXISTING_CONNECTION" + " = " + "true");
                        log4jParamters_tDBInput_8.append(" | ");
                            log4jParamters_tDBInput_8.append("CONNECTION" + " = " + "tDBConnection_2");
                        log4jParamters_tDBInput_8.append(" | ");
                            log4jParamters_tDBInput_8.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_8.append(" | ");
                            log4jParamters_tDBInput_8.append("QUERY" + " = " + "\"SELECT * FROM ARTISTSDIM;\"");
                        log4jParamters_tDBInput_8.append(" | ");
                            log4jParamters_tDBInput_8.append("USE_CURSOR" + " = " + "false");
                        log4jParamters_tDBInput_8.append(" | ");
                            log4jParamters_tDBInput_8.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_8.append(" | ");
                            log4jParamters_tDBInput_8.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("artistkey")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("artistid")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("artistname")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("citykey")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("startdate")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("enddate")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("status_flag")+"}]");
                        log4jParamters_tDBInput_8.append(" | ");
                            log4jParamters_tDBInput_8.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlInput");
                        log4jParamters_tDBInput_8.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBInput_8 - "  + (log4jParamters_tDBInput_8) );
                    } 
                } 
            new BytesLimit65535_tDBInput_8().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBInput_8", "__TABLE__", "tPostgresqlInput");
				talendJobLogProcess(globalMap);
			}
			
	
    
	
		    int nb_line_tDBInput_8 = 0;
		    java.sql.Connection conn_tDBInput_8 = null;
				conn_tDBInput_8 = (java.sql.Connection)globalMap.get("conn_tDBConnection_2");
				
				if(conn_tDBInput_8 != null) {
					if(conn_tDBInput_8.getMetaData() != null) {
						
							log.debug("tDBInput_8 - Uses an existing connection with username '" + conn_tDBInput_8.getMetaData().getUserName() + "'. Connection URL: " + conn_tDBInput_8.getMetaData().getURL() + ".");
						
					}
				}
			
		    
			java.sql.Statement stmt_tDBInput_8 = conn_tDBInput_8.createStatement();

		    String dbquery_tDBInput_8 = "SELECT * FROM ARTISTSDIM;";
		    
	    		log.debug("tDBInput_8 - Executing the query: '" + dbquery_tDBInput_8 + "'.");
			

            	globalMap.put("tDBInput_8_QUERY",dbquery_tDBInput_8);
		    java.sql.ResultSet rs_tDBInput_8 = null;

		    try {
		    	rs_tDBInput_8 = stmt_tDBInput_8.executeQuery(dbquery_tDBInput_8);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_8 = rs_tDBInput_8.getMetaData();
		    	int colQtyInRs_tDBInput_8 = rsmd_tDBInput_8.getColumnCount();

		    String tmpContent_tDBInput_8 = null;
		    
		    
		    	log.debug("tDBInput_8 - Retrieving records from the database.");
		    
		    while (rs_tDBInput_8.next()) {
		        nb_line_tDBInput_8++;
		        
							if(colQtyInRs_tDBInput_8 < 1) {
								row8.artistkey = 0;
							} else {
		                          
            row8.artistkey = rs_tDBInput_8.getInt(1);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 2) {
								row8.artistid = null;
							} else {
	                         		
        	row8.artistid = routines.system.JDBCUtil.getString(rs_tDBInput_8, 2, false);
		                    }
							if(colQtyInRs_tDBInput_8 < 3) {
								row8.artistname = null;
							} else {
	                         		
        	row8.artistname = routines.system.JDBCUtil.getString(rs_tDBInput_8, 3, false);
		                    }
							if(colQtyInRs_tDBInput_8 < 4) {
								row8.citykey = 0;
							} else {
		                          
            row8.citykey = rs_tDBInput_8.getInt(4);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 5) {
								row8.startdate = null;
							} else {
										
			row8.startdate = routines.system.JDBCUtil.getDate(rs_tDBInput_8, 5);
		                    }
							if(colQtyInRs_tDBInput_8 < 6) {
								row8.enddate = null;
							} else {
										
			row8.enddate = routines.system.JDBCUtil.getDate(rs_tDBInput_8, 6);
		                    }
							if(colQtyInRs_tDBInput_8 < 7) {
								row8.status_flag = null;
							} else {
	                         		
        	row8.status_flag = routines.system.JDBCUtil.getString(rs_tDBInput_8, 7, false);
		                    }
					
						log.debug("tDBInput_8 - Retrieving the record " + nb_line_tDBInput_8 + ".");
					


 



/**
 * [tDBInput_8 begin ] stop
 */
	
	/**
	 * [tDBInput_8 main ] start
	 */

	

	
	
	currentComponent="tDBInput_8";

	

 


	tos_count_tDBInput_8++;

/**
 * [tDBInput_8 main ] stop
 */
	
	/**
	 * [tDBInput_8 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_8";

	

 



/**
 * [tDBInput_8 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row8 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row8";

	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row8","tDBInput_8","__TABLE__","tPostgresqlInput","tAdvancedHash_row8","tAdvancedHash_row8","tAdvancedHash"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row8 - " + (row8==null? "": row8.toLogString()));
    			}
    		


			   
			   

					row8Struct row8_HashRow = new row8Struct();
		   	   	   
				
				row8_HashRow.artistkey = row8.artistkey;
				
				row8_HashRow.artistid = row8.artistid;
				
				row8_HashRow.artistname = row8.artistname;
				
				row8_HashRow.citykey = row8.citykey;
				
				row8_HashRow.startdate = row8.startdate;
				
				row8_HashRow.enddate = row8.enddate;
				
				row8_HashRow.status_flag = row8.status_flag;
				
			tHash_Lookup_row8.put(row8_HashRow);
			
            




 


	tos_count_tAdvancedHash_row8++;

/**
 * [tAdvancedHash_row8 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row8 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row8";

	

 



/**
 * [tAdvancedHash_row8 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row8 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row8";

	

 



/**
 * [tAdvancedHash_row8 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_8 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_8";

	

 



/**
 * [tDBInput_8 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_8 end ] start
	 */

	

	
	
	currentComponent="tDBInput_8";

	

	}
}finally{
	if (rs_tDBInput_8 != null) {
		rs_tDBInput_8.close();
	}
	if (stmt_tDBInput_8 != null) {
		stmt_tDBInput_8.close();
	}
}
globalMap.put("tDBInput_8_NB_LINE",nb_line_tDBInput_8);
	    		log.debug("tDBInput_8 - Retrieved records count: "+nb_line_tDBInput_8 + " .");
			
 
                if(log.isDebugEnabled())
            log.debug("tDBInput_8 - "  + ("Done.") );

ok_Hash.put("tDBInput_8", true);
end_Hash.put("tDBInput_8", System.currentTimeMillis());




/**
 * [tDBInput_8 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row8 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row8";

	

tHash_Lookup_row8.endPut();

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row8",2,0,
			 			"tDBInput_8","__TABLE__","tPostgresqlInput","tAdvancedHash_row8","tAdvancedHash_row8","tAdvancedHash","output")) {
						talendJobLogProcess(globalMap);
					}
				
 

ok_Hash.put("tAdvancedHash_row8", true);
end_Hash.put("tAdvancedHash_row8", System.currentTimeMillis());




/**
 * [tAdvancedHash_row8 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_8 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_8";

	

 



/**
 * [tDBInput_8 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row8 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row8";

	

 



/**
 * [tAdvancedHash_row8 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_8_SUBPROCESS_STATE", 1);
	}
	

public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [talendJobLog begin ] start
	 */

	

	
		
		ok_Hash.put("talendJobLog", false);
		start_Hash.put("talendJobLog", System.currentTimeMillis());
		
	
	currentComponent="talendJobLog";

	
		int tos_count_talendJobLog = 0;
		

	for (JobStructureCatcherUtils.JobStructureCatcherMessage jcm : talendJobLog.getMessages()) {
		org.talend.job.audit.JobContextBuilder builder_talendJobLog = org.talend.job.audit.JobContextBuilder.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
			.custom("process_id", jcm.pid).custom("thread_id", jcm.tid).custom("pid", pid).custom("father_pid", fatherPid).custom("root_pid", rootPid);
		org.talend.logging.audit.Context log_context_talendJobLog = null;
		
		
		if(jcm.log_type == JobStructureCatcherUtils.LogType.PERFORMANCE){
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.sourceId(jcm.sourceId).sourceLabel(jcm.sourceLabel).sourceConnectorType(jcm.sourceComponentName)
				.targetId(jcm.targetId).targetLabel(jcm.targetLabel).targetConnectorType(jcm.targetComponentName)
				.connectionName(jcm.current_connector).rows(jcm.row_count).duration(duration).build();
			auditLogger_talendJobLog.flowExecution(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBSTART) {
			log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).build();
			auditLogger_talendJobLog.jobstart(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBEND) {
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
		
			log_context_talendJobLog = builder_talendJobLog
				.timestamp(jcm.moment).duration(duration).status(jcm.status).build();
			auditLogger_talendJobLog.jobstop(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.RUNCOMPONENT) {
			log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment)
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label).build();
			auditLogger_talendJobLog.runcomponent(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.FLOWINPUT) {//log current component input line
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label)
				.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
				.rows(jcm.total_row_number).duration(duration).build();
			auditLogger_talendJobLog.flowInput(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.FLOWOUTPUT) {//log current component output/reject line
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label)
				.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
				.rows(jcm.total_row_number).duration(duration).build();
			auditLogger_talendJobLog.flowOutput(log_context_talendJobLog);
		}
		
		
		
	}

 



/**
 * [talendJobLog begin ] stop
 */
	
	/**
	 * [talendJobLog main ] start
	 */

	

	
	
	currentComponent="talendJobLog";

	

 


	tos_count_talendJobLog++;

/**
 * [talendJobLog main ] stop
 */
	
	/**
	 * [talendJobLog process_data_begin ] start
	 */

	

	
	
	currentComponent="talendJobLog";

	

 



/**
 * [talendJobLog process_data_begin ] stop
 */
	
	/**
	 * [talendJobLog process_data_end ] start
	 */

	

	
	
	currentComponent="talendJobLog";

	

 



/**
 * [talendJobLog process_data_end ] stop
 */
	
	/**
	 * [talendJobLog end ] start
	 */

	

	
	
	currentComponent="talendJobLog";

	

 

ok_Hash.put("talendJobLog", true);
end_Hash.put("talendJobLog", System.currentTimeMillis());




/**
 * [talendJobLog end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [talendJobLog finally ] start
	 */

	

	
	
	currentComponent="talendJobLog";

	

 



/**
 * [talendJobLog finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("talendJobLog_SUBPROCESS_STATE", 1);
	}
	
    public String resuming_logs_dir_path = null;
    public String resuming_checkpoint_path = null;
    public String parent_part_launcher = null;
    private String resumeEntryMethodName = null;
    private boolean globalResumeTicket = false;

    public boolean watch = false;
    // portStats is null, it means don't execute the statistics
    public Integer portStats = null;
    public int portTraces = 4334;
    public String clientHost;
    public String defaultClientHost = "localhost";
    public String contextStr = "Default";
    public boolean isDefaultContext = true;
    public String pid = "0";
    public String rootPid = null;
    public String fatherPid = null;
    public String fatherNode = null;
    public long startTime = 0;
    public boolean isChildJob = false;
    public String log4jLevel = "";
    
    private boolean enableLogStash;

    private boolean execStat = true;

    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
        protected java.util.Map<String, String> initialValue() {
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    

    public static void main(String[] args){
        final FactTable FactTableClass = new FactTable();

        int exitCode = FactTableClass.runJobInTOS(args);
	        if(exitCode==0){
		        log.info("TalendJob: 'FactTable' - Done.");
	        }

        System.exit(exitCode);
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        return hastBufferOutput;
    }

    public int runJobInTOS(String[] args) {
	   	// reset status
	   	status = "";
	   	
        String lastStr = "";
        for (String arg : args) {
            if (arg.equalsIgnoreCase("--context_param")) {
                lastStr = arg;
            } else if (lastStr.equals("")) {
                evalParam(arg);
            } else {
                evalParam(lastStr + " " + arg);
                lastStr = "";
            }
        }
        enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

	        if(!"".equals(log4jLevel)){
	        	
				
				
				if("trace".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.TRACE);
				}else if("debug".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.DEBUG);
				}else if("info".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.INFO);
				}else if("warn".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.WARN);
				}else if("error".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.ERROR);
				}else if("fatal".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.FATAL);
				}else if ("off".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.OFF);
				}
				org.apache.logging.log4j.core.config.Configurator.setLevel(org.apache.logging.log4j.LogManager.getRootLogger().getName(), log.getLevel());
				
    	    }
        	log.info("TalendJob: 'FactTable' - Start.");
    	
    	
    	
			if(enableLogStash) {
				java.util.Properties properties_talendJobLog = new java.util.Properties();
				properties_talendJobLog.setProperty("root.logger", "audit");
				properties_talendJobLog.setProperty("encoding", "UTF-8");
				properties_talendJobLog.setProperty("application.name", "Talend Studio");
				properties_talendJobLog.setProperty("service.name", "Talend Studio Job");
				properties_talendJobLog.setProperty("instance.name", "Talend Studio Job Instance");
				properties_talendJobLog.setProperty("propagate.appender.exceptions", "none");
				properties_talendJobLog.setProperty("log.appender", "file");
				properties_talendJobLog.setProperty("appender.file.path", "audit.json");
				properties_talendJobLog.setProperty("appender.file.maxsize", "52428800");
				properties_talendJobLog.setProperty("appender.file.maxbackup", "20");
				properties_talendJobLog.setProperty("host", "false");

				System.getProperties().stringPropertyNames().stream()
					.filter(it -> it.startsWith("audit.logger."))
					.forEach(key -> properties_talendJobLog.setProperty(key.substring("audit.logger.".length()), System.getProperty(key)));

				
				
				
				org.apache.logging.log4j.core.config.Configurator.setLevel(properties_talendJobLog.getProperty("root.logger"), org.apache.logging.log4j.Level.DEBUG);
				
				auditLogger_talendJobLog = org.talend.job.audit.JobEventAuditLoggerFactory.createJobAuditLogger(properties_talendJobLog);
			}
		

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

        if (rootPid==null) {
            rootPid = pid;
        }
        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }

        if (portStats != null) {
            // portStats = -1; //for testing
            if (portStats < 0 || portStats > 65535) {
                // issue:10869, the portStats is invalid, so this client socket can't open
                System.err.println("The statistics socket port " + portStats + " is invalid.");
                execStat = false;
            }
        } else {
            execStat = false;
        }
        boolean inOSGi = routines.system.BundleUtils.inOSGi();

        if (inOSGi) {
            java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

            if (jobProperties != null && jobProperties.get("context") != null) {
                contextStr = (String)jobProperties.get("context");
            }
        }

        try {
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = FactTable.class.getClassLoader().getResourceAsStream("artistloc/facttable_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = FactTable.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
	                defaultProps.load(inContext);
	                context = new ContextProperties(defaultProps);
                    }
                } finally {
                    inContext.close();
                }
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }

            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
            class ContextProcessing {
                private void processContext_0() {
                } 
                public void processAllContext() {
                        processContext_0();
                }
            }

            new ContextProcessing().processAllContext();
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,parametersToEncrypt));

if(execStat) {
    try {
        runStat.openSocket(!isChildJob);
        runStat.setAllPID(rootPid, fatherPid, pid, jobName);
        runStat.startThreadStat(clientHost, portStats);
        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
    } catch (java.io.IOException ioException) {
        ioException.printStackTrace();
    }
}



	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();


this.globalResumeTicket = true;//to run tPreJob




		if(enableLogStash) {
	        talendJobLog.addJobStartMessage();
	        try {
	            talendJobLogProcess(globalMap);
	        } catch (java.lang.Exception e) {
	            e.printStackTrace();
	        }
        }

this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tDBConnection_2Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tDBConnection_2) {
globalMap.put("tDBConnection_2_SUBPROCESS_STATE", -1);

e_tDBConnection_2.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : FactTable");
        }
		if(enableLogStash) {
	        talendJobLog.addJobEndMessage(startTime, end, status);
	        try {
	            talendJobLogProcess(globalMap);
	        } catch (java.lang.Exception e) {
	            e.printStackTrace();
	        }
        }



if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    int returnCode = 0;


    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {
    closeSqlDbConnections();


    }



    private void closeSqlDbConnections() {
        try {
            Object obj_conn;
            obj_conn = globalMap.remove("conn_tDBConnection_2");
            if (null != obj_conn) {
                ((java.sql.Connection) obj_conn).close();
            }
        } catch (java.lang.Exception e) {
        }
    }











    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();
            connections.put("conn_tDBConnection_2", globalMap.get("conn_tDBConnection_2"));






        return connections;
    }

    private void evalParam(String arg) {
        if (arg.startsWith("--resuming_logs_dir_path")) {
            resuming_logs_dir_path = arg.substring(25);
        } else if (arg.startsWith("--resuming_checkpoint_path")) {
            resuming_checkpoint_path = arg.substring(27);
        } else if (arg.startsWith("--parent_part_launcher")) {
            parent_part_launcher = arg.substring(23);
        } else if (arg.startsWith("--watch")) {
            watch = true;
        } else if (arg.startsWith("--stat_port=")) {
            String portStatsStr = arg.substring(12);
            if (portStatsStr != null && !portStatsStr.equals("null")) {
                portStats = Integer.parseInt(portStatsStr);
            }
        } else if (arg.startsWith("--trace_port=")) {
            portTraces = Integer.parseInt(arg.substring(13));
        } else if (arg.startsWith("--client_host=")) {
            clientHost = arg.substring(14);
        } else if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
            isDefaultContext = false;
        } else if (arg.startsWith("--father_pid=")) {
            fatherPid = arg.substring(13);
        } else if (arg.startsWith("--root_pid=")) {
            rootPid = arg.substring(11);
        } else if (arg.startsWith("--father_node=")) {
            fatherNode = arg.substring(14);
        } else if (arg.startsWith("--pid=")) {
            pid = arg.substring(6);
        } else if (arg.startsWith("--context_type")) {
            String keyValue = arg.substring(15);
			int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        } else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getStatus() {
        return status;
    }

    ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 *     238890 characters generated by Talend Real-time Big Data Platform 
 *     on the November 15, 2024 at 1:49:23 PM EST
 ************************************************************************************************/