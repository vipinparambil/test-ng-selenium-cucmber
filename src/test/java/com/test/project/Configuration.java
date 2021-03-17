package com.test.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Configuration {

    public String appUri;
    public String driverOptions;
    public String browser;
    public long driverDefaultWaitSeconds;
    public boolean screenShotBefore = false;
    

    public String getAppUri() {
		return appUri;
	}

	public void setAppUri(String appUri) {
		this.appUri = appUri;
	}


	public String getDriverOptions() {
		return driverOptions;
	}

	public void setDriverOptions(String driverOptions) {
		this.driverOptions = driverOptions;
	}

	public long getDriverDefaultWaitSeconds() {
		return driverDefaultWaitSeconds;
	}

	public void setDriverDefaultWaitSeconds(long driverDefaultWaitSeconds) {
		this.driverDefaultWaitSeconds = driverDefaultWaitSeconds;
	}

	public boolean isScreenShotBefore() {
		return screenShotBefore;
	}

	public void setScreenShotBefore(boolean screenShotBefore) {
		this.screenShotBefore = screenShotBefore;
	}
	
    public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String[] driverOptions() {
        if (this.driverOptions.trim().length() == 0) {
            return new String[0];
        }
        String[] optionList = this.driverOptions.split(";");
        return optionList;
    }

    public long driverDefaultWaitSeconds() {
        return this.driverDefaultWaitSeconds;
    }


}
