package org.jobrunr.jobs.carbonaware;

import java.time.Duration;

import static org.jobrunr.jobs.carbonaware.CarbonAwareConfigurationReader.getCarbonIntensityForecastApiUrl;

// TODO review some of the javadocs
public class CarbonAwareConfiguration {

    public static String DEFAULT_CARBON_INTENSITY_API_URL = getCarbonIntensityForecastApiUrl("https://api.jobrunr.io");
    public static Duration DEFAULT_CLIENT_API_CONNECT_TIMEOUT = Duration.ofSeconds(3);
    public static Duration DEFAULT_CLIENT_API_READ_TIMEOUT = Duration.ofSeconds(3);

    String carbonIntensityApiUrl = DEFAULT_CARBON_INTENSITY_API_URL;
    String areaCode;
    Duration apiClientConnectTimeout = DEFAULT_CLIENT_API_CONNECT_TIMEOUT;
    Duration apiClientReadTimeout = DEFAULT_CLIENT_API_READ_TIMEOUT;

    private CarbonAwareConfiguration() {
    }

    /**
     * This returns the default carbon aware configuration to schedule jobs at low carbon emission moments
     *
     * @return the default CarbonAware configuration
     */
    public static CarbonAwareConfiguration usingStandardCarbonAwareConfiguration() {
        return new CarbonAwareConfiguration();
    }

    /**
     * Allows to set the areaCode of your datacenter (the area where your application is hosted) in order to have more accurate carbon emissions forecasts.
     *
     * @param areaCode a supported area code (e.g., ISO 3166-2 code like 'BE' or 'US-CA' or a cloud provider region code).
     * @return the same configuration instance which provides a fluent api
     */
    public CarbonAwareConfiguration andAreaCode(String areaCode) {
        this.areaCode = areaCode;
        return this;
    }

    /**
     * Allows to set the carbon intensity API URL
     */
    public CarbonAwareConfiguration andCarbonIntensityApiUrl(String carbonIntensityApiUrl) {
        this.carbonIntensityApiUrl = carbonIntensityApiUrl;
        return this;
    }

    /**
     * Allows to set the connect timeout for the API client
     */
    public CarbonAwareConfiguration andApiClientConnectTimeout(Duration apiClientConnectTimeout) {
        this.apiClientConnectTimeout = apiClientConnectTimeout;
        return this;
    }

    /**
     * Allows to set the read timeout for the API client
     */
    public CarbonAwareConfiguration andApiClientReadTimeout(Duration apiClientReadTimeout) {
        this.apiClientReadTimeout = apiClientReadTimeout;
        return this;
    }
}
