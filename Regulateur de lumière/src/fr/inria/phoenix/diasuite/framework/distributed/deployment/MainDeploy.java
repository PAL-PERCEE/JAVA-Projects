package fr.inria.phoenix.diasuite.framework.distributed.deployment;

import fr.inria.diagen.core.deploy.AbstractDeploy;
import fr.inria.diagen.log.DiaLog;

import fr.inria.phoenix.diasuite.framework.distributed.contactsensor.AbstractContactSensor;
import fr.inria.phoenix.diasuite.framework.distributed.smarttv.AbstractSmartTv;
import fr.inria.phoenix.diasuite.framework.distributed.temperaturesensor.AbstractTemperatureSensor;
import fr.inria.phoenix.diasuite.framework.distributed.input.AbstractInput;
import fr.inria.phoenix.diasuite.framework.distributed.taskmanager.AbstractTaskManager;
import fr.inria.phoenix.diasuite.framework.distributed.dimmablelight.AbstractDimmableLight;
import fr.inria.phoenix.diasuite.framework.distributed.service.AbstractService;
import fr.inria.phoenix.diasuite.framework.distributed.smssender.AbstractSMSSender;
import fr.inria.phoenix.diasuite.framework.distributed.energymeter.AbstractEnergyMeter;
import fr.inria.phoenix.diasuite.framework.distributed.tvmessenger.AbstractTvMessenger;
import fr.inria.phoenix.diasuite.framework.distributed.speaker.AbstractSpeaker;
import fr.inria.phoenix.diasuite.framework.distributed.builtin.AbstractBuiltIn;
import fr.inria.phoenix.diasuite.framework.distributed.instantmessenger.AbstractInstantMessenger;
import fr.inria.phoenix.diasuite.framework.distributed.ptzvideocamera.AbstractPTZVideoCamera;
import fr.inria.phoenix.diasuite.framework.distributed.shutter.AbstractShutter;
import fr.inria.phoenix.diasuite.framework.distributed.visualnotifier.AbstractVisualNotifier;
import fr.inria.phoenix.diasuite.framework.distributed.physicaldevice.AbstractPhysicalDevice;
import fr.inria.phoenix.diasuite.framework.distributed.fan.AbstractFan;
import fr.inria.phoenix.diasuite.framework.distributed.identifier.AbstractIdentifier;
import fr.inria.phoenix.diasuite.framework.distributed.storage.AbstractStorage;
import fr.inria.phoenix.diasuite.framework.distributed.tvprompter.AbstractTvPrompter;
import fr.inria.phoenix.diasuite.framework.distributed.tv.AbstractTv;
import fr.inria.phoenix.diasuite.framework.distributed.networkstorage.AbstractNetworkStorage;
import fr.inria.phoenix.diasuite.framework.distributed.gasmeter.AbstractGasMeter;
import fr.inria.phoenix.diasuite.framework.distributed.servicetablet.AbstractServiceTablet;
import fr.inria.phoenix.diasuite.framework.distributed.fingerprintidentifier.AbstractFingerPrintIdentifier;
import fr.inria.phoenix.diasuite.framework.distributed.rfididentifier.AbstractRfidIdentifier;
import fr.inria.phoenix.diasuite.framework.distributed.audioprompter.AbstractAudioPrompter;
import fr.inria.phoenix.diasuite.framework.distributed.device.AbstractDevice;
import fr.inria.phoenix.diasuite.framework.distributed.videocamera.AbstractVideoCamera;
import fr.inria.phoenix.diasuite.framework.distributed.telephonygateway.AbstractTelephonyGateway;
import fr.inria.phoenix.diasuite.framework.distributed.mobilestorage.AbstractMobileStorage;
import fr.inria.phoenix.diasuite.framework.distributed.heater.AbstractHeater;
import fr.inria.phoenix.diasuite.framework.distributed.timer.AbstractTimer;
import fr.inria.phoenix.diasuite.framework.distributed.remotecontrol.AbstractRemoteControl;
import fr.inria.phoenix.diasuite.framework.distributed.weatherforecaster.AbstractWeatherForecaster;
import fr.inria.phoenix.diasuite.framework.distributed.personaladdressbook.AbstractPersonalAddressBook;
import fr.inria.phoenix.diasuite.framework.distributed.cosensor.AbstractCOSensor;
import fr.inria.phoenix.diasuite.framework.distributed.camera.AbstractCamera;
import fr.inria.phoenix.diasuite.framework.distributed.addressbook.AbstractAddressBook;
import fr.inria.phoenix.diasuite.framework.distributed.sensor.AbstractSensor;
import fr.inria.phoenix.diasuite.framework.distributed.alarm.AbstractAlarm;
import fr.inria.phoenix.diasuite.framework.distributed.thermostat.AbstractThermostat;
import fr.inria.phoenix.diasuite.framework.distributed.bluetoothidentifier.AbstractBluetoothIdentifier;
import fr.inria.phoenix.diasuite.framework.distributed.homeservice.AbstractHomeService;
import fr.inria.phoenix.diasuite.framework.distributed.audioinput.AbstractAudioInput;
import fr.inria.phoenix.diasuite.framework.distributed.doorlocker.AbstractDoorLocker;
import fr.inria.phoenix.diasuite.framework.distributed.watermeter.AbstractWaterMeter;
import fr.inria.phoenix.diasuite.framework.distributed.userservice.AbstractUserService;
import fr.inria.phoenix.diasuite.framework.distributed.microphone.AbstractMicrophone;
import fr.inria.phoenix.diasuite.framework.distributed.appliancedashboard.AbstractApplianceDashBoard;
import fr.inria.phoenix.diasuite.framework.distributed.messenger.AbstractMessenger;
import fr.inria.phoenix.diasuite.framework.distributed.mailer.AbstractMailer;
import fr.inria.phoenix.diasuite.framework.distributed.communicationservice.AbstractCommunicationService;
import fr.inria.phoenix.diasuite.framework.distributed.motiondetector.AbstractMotionDetector;
import fr.inria.phoenix.diasuite.framework.distributed.button.AbstractButton;
import fr.inria.phoenix.diasuite.framework.distributed.lightsensor.AbstractLightSensor;
import fr.inria.phoenix.diasuite.framework.distributed.audiomessenger.AbstractAudioMessenger;
import fr.inria.phoenix.diasuite.framework.distributed.smokesensor.AbstractSmokeSensor;
import fr.inria.phoenix.diasuite.framework.distributed.texttospeech.AbstractTextToSpeech;
import fr.inria.phoenix.diasuite.framework.distributed.electricmeter.AbstractElectricMeter;
import fr.inria.phoenix.diasuite.framework.distributed.screeninput.AbstractScreenInput;
import fr.inria.phoenix.diasuite.framework.distributed.ihm.AbstractIHM;
import fr.inria.phoenix.diasuite.framework.distributed.keypad.AbstractKeyPad;
import fr.inria.phoenix.diasuite.framework.distributed.overflowsensor.AbstractOverflowSensor;
import fr.inria.phoenix.diasuite.framework.distributed.localstorage.AbstractLocalStorage;
import fr.inria.phoenix.diasuite.framework.distributed.prompter.AbstractPrompter;
import fr.inria.phoenix.diasuite.framework.distributed.light.AbstractLight;
import fr.inria.phoenix.diasuite.framework.distributed.screenprompter.AbstractScreenPrompter;
import fr.inria.phoenix.diasuite.framework.distributed.appliance.AbstractAppliance;
import fr.inria.phoenix.diasuite.framework.distributed.screenmessenger.AbstractScreenMessenger;
import fr.inria.phoenix.diasuite.framework.distributed.setpointconsole.AbstractSetPointConsole;
import fr.inria.phoenix.diasuite.framework.distributed.agenda.AbstractAgenda;
import fr.inria.phoenix.diasuite.framework.distributed.audionotifier.AbstractAudioNotifier;
import fr.inria.phoenix.diasuite.framework.distributed.tvrecorder.AbstractTvRecorder;
import fr.inria.phoenix.diasuite.framework.distributed.tvguide.AbstractTvGuide;
import fr.inria.phoenix.diasuite.framework.distributed.photoframe.AbstractPhotoFrame;
import fr.inria.phoenix.diasuite.framework.distributed.notifier.AbstractNotifier;
import fr.inria.phoenix.diasuite.framework.distributed.clock.AbstractClock;

import fr.inria.phoenix.diasuite.framework.distributed.lumierecalculee.AbstractLumiereCalculee;
import fr.inria.phoenix.diasuite.framework.distributed.regulationindicator.AbstractRegulationIndicator;

import fr.inria.phoenix.diasuite.framework.distributed.tutorial_phoenixcontroller.AbstractTutorial_phoenixController;


public abstract class MainDeploy extends AbstractDeploy {

	private AbstractLumiereCalculee lumiereCalculeeInstance = null;
	private AbstractRegulationIndicator regulationIndicatorInstance = null;


	private AbstractTutorial_phoenixController tutorial_phoenixControllerInstance = null;


	public MainDeploy() {
		DiaLog.setLevel(DiaLog.WARNING);
	}

	private final java.util.List<AbstractContactSensor> contactSensorList = new java.util.LinkedList<AbstractContactSensor>();

	public java.util.List<AbstractContactSensor> getContactSensors() {
		return contactSensorList;
	}

	public void add(AbstractContactSensor contactSensor) {
		contactSensorList.add(contactSensor);
	}

	public void remove(AbstractContactSensor contactSensor) {
		contactSensorList.remove(contactSensor);
	}
	private final java.util.List<AbstractSmartTv> smartTvList = new java.util.LinkedList<AbstractSmartTv>();

	public java.util.List<AbstractSmartTv> getSmartTvs() {
		return smartTvList;
	}

	public void add(AbstractSmartTv smartTv) {
		smartTvList.add(smartTv);
	}

	public void remove(AbstractSmartTv smartTv) {
		smartTvList.remove(smartTv);
	}
	private final java.util.List<AbstractTemperatureSensor> temperatureSensorList = new java.util.LinkedList<AbstractTemperatureSensor>();

	public java.util.List<AbstractTemperatureSensor> getTemperatureSensors() {
		return temperatureSensorList;
	}

	public void add(AbstractTemperatureSensor temperatureSensor) {
		temperatureSensorList.add(temperatureSensor);
	}

	public void remove(AbstractTemperatureSensor temperatureSensor) {
		temperatureSensorList.remove(temperatureSensor);
	}
	private final java.util.List<AbstractInput> inputList = new java.util.LinkedList<AbstractInput>();

	public java.util.List<AbstractInput> getInputs() {
		return inputList;
	}

	public void add(AbstractInput input) {
		inputList.add(input);
	}

	public void remove(AbstractInput input) {
		inputList.remove(input);
	}
	private final java.util.List<AbstractTaskManager> taskManagerList = new java.util.LinkedList<AbstractTaskManager>();

	public java.util.List<AbstractTaskManager> getTaskManagers() {
		return taskManagerList;
	}

	public void add(AbstractTaskManager taskManager) {
		taskManagerList.add(taskManager);
	}

	public void remove(AbstractTaskManager taskManager) {
		taskManagerList.remove(taskManager);
	}
	private final java.util.List<AbstractDimmableLight> dimmableLightList = new java.util.LinkedList<AbstractDimmableLight>();

	public java.util.List<AbstractDimmableLight> getDimmableLights() {
		return dimmableLightList;
	}

	public void add(AbstractDimmableLight dimmableLight) {
		dimmableLightList.add(dimmableLight);
	}

	public void remove(AbstractDimmableLight dimmableLight) {
		dimmableLightList.remove(dimmableLight);
	}
	private final java.util.List<AbstractService> serviceList = new java.util.LinkedList<AbstractService>();

	public java.util.List<AbstractService> getServices() {
		return serviceList;
	}

	public void add(AbstractService service) {
		serviceList.add(service);
	}

	public void remove(AbstractService service) {
		serviceList.remove(service);
	}
	private final java.util.List<AbstractSMSSender> sMSSenderList = new java.util.LinkedList<AbstractSMSSender>();

	public java.util.List<AbstractSMSSender> getSMSSenders() {
		return sMSSenderList;
	}

	public void add(AbstractSMSSender sMSSender) {
		sMSSenderList.add(sMSSender);
	}

	public void remove(AbstractSMSSender sMSSender) {
		sMSSenderList.remove(sMSSender);
	}
	private final java.util.List<AbstractEnergyMeter> energyMeterList = new java.util.LinkedList<AbstractEnergyMeter>();

	public java.util.List<AbstractEnergyMeter> getEnergyMeters() {
		return energyMeterList;
	}

	public void add(AbstractEnergyMeter energyMeter) {
		energyMeterList.add(energyMeter);
	}

	public void remove(AbstractEnergyMeter energyMeter) {
		energyMeterList.remove(energyMeter);
	}
	private final java.util.List<AbstractTvMessenger> tvMessengerList = new java.util.LinkedList<AbstractTvMessenger>();

	public java.util.List<AbstractTvMessenger> getTvMessengers() {
		return tvMessengerList;
	}

	public void add(AbstractTvMessenger tvMessenger) {
		tvMessengerList.add(tvMessenger);
	}

	public void remove(AbstractTvMessenger tvMessenger) {
		tvMessengerList.remove(tvMessenger);
	}
	private final java.util.List<AbstractSpeaker> speakerList = new java.util.LinkedList<AbstractSpeaker>();

	public java.util.List<AbstractSpeaker> getSpeakers() {
		return speakerList;
	}

	public void add(AbstractSpeaker speaker) {
		speakerList.add(speaker);
	}

	public void remove(AbstractSpeaker speaker) {
		speakerList.remove(speaker);
	}
	private final java.util.List<AbstractBuiltIn> builtInList = new java.util.LinkedList<AbstractBuiltIn>();

	public java.util.List<AbstractBuiltIn> getBuiltIns() {
		return builtInList;
	}

	public void add(AbstractBuiltIn builtIn) {
		builtInList.add(builtIn);
	}

	public void remove(AbstractBuiltIn builtIn) {
		builtInList.remove(builtIn);
	}
	private final java.util.List<AbstractInstantMessenger> instantMessengerList = new java.util.LinkedList<AbstractInstantMessenger>();

	public java.util.List<AbstractInstantMessenger> getInstantMessengers() {
		return instantMessengerList;
	}

	public void add(AbstractInstantMessenger instantMessenger) {
		instantMessengerList.add(instantMessenger);
	}

	public void remove(AbstractInstantMessenger instantMessenger) {
		instantMessengerList.remove(instantMessenger);
	}
	private final java.util.List<AbstractPTZVideoCamera> pTZVideoCameraList = new java.util.LinkedList<AbstractPTZVideoCamera>();

	public java.util.List<AbstractPTZVideoCamera> getPTZVideoCameras() {
		return pTZVideoCameraList;
	}

	public void add(AbstractPTZVideoCamera pTZVideoCamera) {
		pTZVideoCameraList.add(pTZVideoCamera);
	}

	public void remove(AbstractPTZVideoCamera pTZVideoCamera) {
		pTZVideoCameraList.remove(pTZVideoCamera);
	}
	private final java.util.List<AbstractShutter> shutterList = new java.util.LinkedList<AbstractShutter>();

	public java.util.List<AbstractShutter> getShutters() {
		return shutterList;
	}

	public void add(AbstractShutter shutter) {
		shutterList.add(shutter);
	}

	public void remove(AbstractShutter shutter) {
		shutterList.remove(shutter);
	}
	private final java.util.List<AbstractVisualNotifier> visualNotifierList = new java.util.LinkedList<AbstractVisualNotifier>();

	public java.util.List<AbstractVisualNotifier> getVisualNotifiers() {
		return visualNotifierList;
	}

	public void add(AbstractVisualNotifier visualNotifier) {
		visualNotifierList.add(visualNotifier);
	}

	public void remove(AbstractVisualNotifier visualNotifier) {
		visualNotifierList.remove(visualNotifier);
	}
	private final java.util.List<AbstractPhysicalDevice> physicalDeviceList = new java.util.LinkedList<AbstractPhysicalDevice>();

	public java.util.List<AbstractPhysicalDevice> getPhysicalDevices() {
		return physicalDeviceList;
	}

	public void add(AbstractPhysicalDevice physicalDevice) {
		physicalDeviceList.add(physicalDevice);
	}

	public void remove(AbstractPhysicalDevice physicalDevice) {
		physicalDeviceList.remove(physicalDevice);
	}
	private final java.util.List<AbstractFan> fanList = new java.util.LinkedList<AbstractFan>();

	public java.util.List<AbstractFan> getFans() {
		return fanList;
	}

	public void add(AbstractFan fan) {
		fanList.add(fan);
	}

	public void remove(AbstractFan fan) {
		fanList.remove(fan);
	}
	private final java.util.List<AbstractIdentifier> identifierList = new java.util.LinkedList<AbstractIdentifier>();

	public java.util.List<AbstractIdentifier> getIdentifiers() {
		return identifierList;
	}

	public void add(AbstractIdentifier identifier) {
		identifierList.add(identifier);
	}

	public void remove(AbstractIdentifier identifier) {
		identifierList.remove(identifier);
	}
	private final java.util.List<AbstractStorage> storageList = new java.util.LinkedList<AbstractStorage>();

	public java.util.List<AbstractStorage> getStorages() {
		return storageList;
	}

	public void add(AbstractStorage storage) {
		storageList.add(storage);
	}

	public void remove(AbstractStorage storage) {
		storageList.remove(storage);
	}
	private final java.util.List<AbstractTvPrompter> tvPrompterList = new java.util.LinkedList<AbstractTvPrompter>();

	public java.util.List<AbstractTvPrompter> getTvPrompters() {
		return tvPrompterList;
	}

	public void add(AbstractTvPrompter tvPrompter) {
		tvPrompterList.add(tvPrompter);
	}

	public void remove(AbstractTvPrompter tvPrompter) {
		tvPrompterList.remove(tvPrompter);
	}
	private final java.util.List<AbstractTv> tvList = new java.util.LinkedList<AbstractTv>();

	public java.util.List<AbstractTv> getTvs() {
		return tvList;
	}

	public void add(AbstractTv tv) {
		tvList.add(tv);
	}

	public void remove(AbstractTv tv) {
		tvList.remove(tv);
	}
	private final java.util.List<AbstractNetworkStorage> networkStorageList = new java.util.LinkedList<AbstractNetworkStorage>();

	public java.util.List<AbstractNetworkStorage> getNetworkStorages() {
		return networkStorageList;
	}

	public void add(AbstractNetworkStorage networkStorage) {
		networkStorageList.add(networkStorage);
	}

	public void remove(AbstractNetworkStorage networkStorage) {
		networkStorageList.remove(networkStorage);
	}
	private final java.util.List<AbstractGasMeter> gasMeterList = new java.util.LinkedList<AbstractGasMeter>();

	public java.util.List<AbstractGasMeter> getGasMeters() {
		return gasMeterList;
	}

	public void add(AbstractGasMeter gasMeter) {
		gasMeterList.add(gasMeter);
	}

	public void remove(AbstractGasMeter gasMeter) {
		gasMeterList.remove(gasMeter);
	}
	private final java.util.List<AbstractServiceTablet> serviceTabletList = new java.util.LinkedList<AbstractServiceTablet>();

	public java.util.List<AbstractServiceTablet> getServiceTablets() {
		return serviceTabletList;
	}

	public void add(AbstractServiceTablet serviceTablet) {
		serviceTabletList.add(serviceTablet);
	}

	public void remove(AbstractServiceTablet serviceTablet) {
		serviceTabletList.remove(serviceTablet);
	}
	private final java.util.List<AbstractFingerPrintIdentifier> fingerPrintIdentifierList = new java.util.LinkedList<AbstractFingerPrintIdentifier>();

	public java.util.List<AbstractFingerPrintIdentifier> getFingerPrintIdentifiers() {
		return fingerPrintIdentifierList;
	}

	public void add(AbstractFingerPrintIdentifier fingerPrintIdentifier) {
		fingerPrintIdentifierList.add(fingerPrintIdentifier);
	}

	public void remove(AbstractFingerPrintIdentifier fingerPrintIdentifier) {
		fingerPrintIdentifierList.remove(fingerPrintIdentifier);
	}
	private final java.util.List<AbstractRfidIdentifier> rfidIdentifierList = new java.util.LinkedList<AbstractRfidIdentifier>();

	public java.util.List<AbstractRfidIdentifier> getRfidIdentifiers() {
		return rfidIdentifierList;
	}

	public void add(AbstractRfidIdentifier rfidIdentifier) {
		rfidIdentifierList.add(rfidIdentifier);
	}

	public void remove(AbstractRfidIdentifier rfidIdentifier) {
		rfidIdentifierList.remove(rfidIdentifier);
	}
	private final java.util.List<AbstractAudioPrompter> audioPrompterList = new java.util.LinkedList<AbstractAudioPrompter>();

	public java.util.List<AbstractAudioPrompter> getAudioPrompters() {
		return audioPrompterList;
	}

	public void add(AbstractAudioPrompter audioPrompter) {
		audioPrompterList.add(audioPrompter);
	}

	public void remove(AbstractAudioPrompter audioPrompter) {
		audioPrompterList.remove(audioPrompter);
	}
	private final java.util.List<AbstractDevice> deviceList = new java.util.LinkedList<AbstractDevice>();

	public java.util.List<AbstractDevice> getDevices() {
		return deviceList;
	}

	public void add(AbstractDevice device) {
		deviceList.add(device);
	}

	public void remove(AbstractDevice device) {
		deviceList.remove(device);
	}
	private final java.util.List<AbstractVideoCamera> videoCameraList = new java.util.LinkedList<AbstractVideoCamera>();

	public java.util.List<AbstractVideoCamera> getVideoCameras() {
		return videoCameraList;
	}

	public void add(AbstractVideoCamera videoCamera) {
		videoCameraList.add(videoCamera);
	}

	public void remove(AbstractVideoCamera videoCamera) {
		videoCameraList.remove(videoCamera);
	}
	private final java.util.List<AbstractTelephonyGateway> telephonyGatewayList = new java.util.LinkedList<AbstractTelephonyGateway>();

	public java.util.List<AbstractTelephonyGateway> getTelephonyGateways() {
		return telephonyGatewayList;
	}

	public void add(AbstractTelephonyGateway telephonyGateway) {
		telephonyGatewayList.add(telephonyGateway);
	}

	public void remove(AbstractTelephonyGateway telephonyGateway) {
		telephonyGatewayList.remove(telephonyGateway);
	}
	private final java.util.List<AbstractMobileStorage> mobileStorageList = new java.util.LinkedList<AbstractMobileStorage>();

	public java.util.List<AbstractMobileStorage> getMobileStorages() {
		return mobileStorageList;
	}

	public void add(AbstractMobileStorage mobileStorage) {
		mobileStorageList.add(mobileStorage);
	}

	public void remove(AbstractMobileStorage mobileStorage) {
		mobileStorageList.remove(mobileStorage);
	}
	private final java.util.List<AbstractHeater> heaterList = new java.util.LinkedList<AbstractHeater>();

	public java.util.List<AbstractHeater> getHeaters() {
		return heaterList;
	}

	public void add(AbstractHeater heater) {
		heaterList.add(heater);
	}

	public void remove(AbstractHeater heater) {
		heaterList.remove(heater);
	}
	private final java.util.List<AbstractTimer> timerList = new java.util.LinkedList<AbstractTimer>();

	public java.util.List<AbstractTimer> getTimers() {
		return timerList;
	}

	public void add(AbstractTimer timer) {
		timerList.add(timer);
	}

	public void remove(AbstractTimer timer) {
		timerList.remove(timer);
	}
	private final java.util.List<AbstractRemoteControl> remoteControlList = new java.util.LinkedList<AbstractRemoteControl>();

	public java.util.List<AbstractRemoteControl> getRemoteControls() {
		return remoteControlList;
	}

	public void add(AbstractRemoteControl remoteControl) {
		remoteControlList.add(remoteControl);
	}

	public void remove(AbstractRemoteControl remoteControl) {
		remoteControlList.remove(remoteControl);
	}
	private final java.util.List<AbstractWeatherForecaster> weatherForecasterList = new java.util.LinkedList<AbstractWeatherForecaster>();

	public java.util.List<AbstractWeatherForecaster> getWeatherForecasters() {
		return weatherForecasterList;
	}

	public void add(AbstractWeatherForecaster weatherForecaster) {
		weatherForecasterList.add(weatherForecaster);
	}

	public void remove(AbstractWeatherForecaster weatherForecaster) {
		weatherForecasterList.remove(weatherForecaster);
	}
	private final java.util.List<AbstractPersonalAddressBook> personalAddressBookList = new java.util.LinkedList<AbstractPersonalAddressBook>();

	public java.util.List<AbstractPersonalAddressBook> getPersonalAddressBooks() {
		return personalAddressBookList;
	}

	public void add(AbstractPersonalAddressBook personalAddressBook) {
		personalAddressBookList.add(personalAddressBook);
	}

	public void remove(AbstractPersonalAddressBook personalAddressBook) {
		personalAddressBookList.remove(personalAddressBook);
	}
	private final java.util.List<AbstractCOSensor> cOSensorList = new java.util.LinkedList<AbstractCOSensor>();

	public java.util.List<AbstractCOSensor> getCOSensors() {
		return cOSensorList;
	}

	public void add(AbstractCOSensor cOSensor) {
		cOSensorList.add(cOSensor);
	}

	public void remove(AbstractCOSensor cOSensor) {
		cOSensorList.remove(cOSensor);
	}
	private final java.util.List<AbstractCamera> cameraList = new java.util.LinkedList<AbstractCamera>();

	public java.util.List<AbstractCamera> getCameras() {
		return cameraList;
	}

	public void add(AbstractCamera camera) {
		cameraList.add(camera);
	}

	public void remove(AbstractCamera camera) {
		cameraList.remove(camera);
	}
	private final java.util.List<AbstractAddressBook> addressBookList = new java.util.LinkedList<AbstractAddressBook>();

	public java.util.List<AbstractAddressBook> getAddressBooks() {
		return addressBookList;
	}

	public void add(AbstractAddressBook addressBook) {
		addressBookList.add(addressBook);
	}

	public void remove(AbstractAddressBook addressBook) {
		addressBookList.remove(addressBook);
	}
	private final java.util.List<AbstractSensor> sensorList = new java.util.LinkedList<AbstractSensor>();

	public java.util.List<AbstractSensor> getSensors() {
		return sensorList;
	}

	public void add(AbstractSensor sensor) {
		sensorList.add(sensor);
	}

	public void remove(AbstractSensor sensor) {
		sensorList.remove(sensor);
	}
	private final java.util.List<AbstractAlarm> alarmList = new java.util.LinkedList<AbstractAlarm>();

	public java.util.List<AbstractAlarm> getAlarms() {
		return alarmList;
	}

	public void add(AbstractAlarm alarm) {
		alarmList.add(alarm);
	}

	public void remove(AbstractAlarm alarm) {
		alarmList.remove(alarm);
	}
	private final java.util.List<AbstractThermostat> thermostatList = new java.util.LinkedList<AbstractThermostat>();

	public java.util.List<AbstractThermostat> getThermostats() {
		return thermostatList;
	}

	public void add(AbstractThermostat thermostat) {
		thermostatList.add(thermostat);
	}

	public void remove(AbstractThermostat thermostat) {
		thermostatList.remove(thermostat);
	}
	private final java.util.List<AbstractBluetoothIdentifier> bluetoothIdentifierList = new java.util.LinkedList<AbstractBluetoothIdentifier>();

	public java.util.List<AbstractBluetoothIdentifier> getBluetoothIdentifiers() {
		return bluetoothIdentifierList;
	}

	public void add(AbstractBluetoothIdentifier bluetoothIdentifier) {
		bluetoothIdentifierList.add(bluetoothIdentifier);
	}

	public void remove(AbstractBluetoothIdentifier bluetoothIdentifier) {
		bluetoothIdentifierList.remove(bluetoothIdentifier);
	}
	private final java.util.List<AbstractHomeService> homeServiceList = new java.util.LinkedList<AbstractHomeService>();

	public java.util.List<AbstractHomeService> getHomeServices() {
		return homeServiceList;
	}

	public void add(AbstractHomeService homeService) {
		homeServiceList.add(homeService);
	}

	public void remove(AbstractHomeService homeService) {
		homeServiceList.remove(homeService);
	}
	private final java.util.List<AbstractAudioInput> audioInputList = new java.util.LinkedList<AbstractAudioInput>();

	public java.util.List<AbstractAudioInput> getAudioInputs() {
		return audioInputList;
	}

	public void add(AbstractAudioInput audioInput) {
		audioInputList.add(audioInput);
	}

	public void remove(AbstractAudioInput audioInput) {
		audioInputList.remove(audioInput);
	}
	private final java.util.List<AbstractDoorLocker> doorLockerList = new java.util.LinkedList<AbstractDoorLocker>();

	public java.util.List<AbstractDoorLocker> getDoorLockers() {
		return doorLockerList;
	}

	public void add(AbstractDoorLocker doorLocker) {
		doorLockerList.add(doorLocker);
	}

	public void remove(AbstractDoorLocker doorLocker) {
		doorLockerList.remove(doorLocker);
	}
	private final java.util.List<AbstractWaterMeter> waterMeterList = new java.util.LinkedList<AbstractWaterMeter>();

	public java.util.List<AbstractWaterMeter> getWaterMeters() {
		return waterMeterList;
	}

	public void add(AbstractWaterMeter waterMeter) {
		waterMeterList.add(waterMeter);
	}

	public void remove(AbstractWaterMeter waterMeter) {
		waterMeterList.remove(waterMeter);
	}
	private final java.util.List<AbstractUserService> userServiceList = new java.util.LinkedList<AbstractUserService>();

	public java.util.List<AbstractUserService> getUserServices() {
		return userServiceList;
	}

	public void add(AbstractUserService userService) {
		userServiceList.add(userService);
	}

	public void remove(AbstractUserService userService) {
		userServiceList.remove(userService);
	}
	private final java.util.List<AbstractMicrophone> microphoneList = new java.util.LinkedList<AbstractMicrophone>();

	public java.util.List<AbstractMicrophone> getMicrophones() {
		return microphoneList;
	}

	public void add(AbstractMicrophone microphone) {
		microphoneList.add(microphone);
	}

	public void remove(AbstractMicrophone microphone) {
		microphoneList.remove(microphone);
	}
	private final java.util.List<AbstractApplianceDashBoard> applianceDashBoardList = new java.util.LinkedList<AbstractApplianceDashBoard>();

	public java.util.List<AbstractApplianceDashBoard> getApplianceDashBoards() {
		return applianceDashBoardList;
	}

	public void add(AbstractApplianceDashBoard applianceDashBoard) {
		applianceDashBoardList.add(applianceDashBoard);
	}

	public void remove(AbstractApplianceDashBoard applianceDashBoard) {
		applianceDashBoardList.remove(applianceDashBoard);
	}
	private final java.util.List<AbstractMessenger> messengerList = new java.util.LinkedList<AbstractMessenger>();

	public java.util.List<AbstractMessenger> getMessengers() {
		return messengerList;
	}

	public void add(AbstractMessenger messenger) {
		messengerList.add(messenger);
	}

	public void remove(AbstractMessenger messenger) {
		messengerList.remove(messenger);
	}
	private final java.util.List<AbstractMailer> mailerList = new java.util.LinkedList<AbstractMailer>();

	public java.util.List<AbstractMailer> getMailers() {
		return mailerList;
	}

	public void add(AbstractMailer mailer) {
		mailerList.add(mailer);
	}

	public void remove(AbstractMailer mailer) {
		mailerList.remove(mailer);
	}
	private final java.util.List<AbstractCommunicationService> communicationServiceList = new java.util.LinkedList<AbstractCommunicationService>();

	public java.util.List<AbstractCommunicationService> getCommunicationServices() {
		return communicationServiceList;
	}

	public void add(AbstractCommunicationService communicationService) {
		communicationServiceList.add(communicationService);
	}

	public void remove(AbstractCommunicationService communicationService) {
		communicationServiceList.remove(communicationService);
	}
	private final java.util.List<AbstractMotionDetector> motionDetectorList = new java.util.LinkedList<AbstractMotionDetector>();

	public java.util.List<AbstractMotionDetector> getMotionDetectors() {
		return motionDetectorList;
	}

	public void add(AbstractMotionDetector motionDetector) {
		motionDetectorList.add(motionDetector);
	}

	public void remove(AbstractMotionDetector motionDetector) {
		motionDetectorList.remove(motionDetector);
	}
	private final java.util.List<AbstractButton> buttonList = new java.util.LinkedList<AbstractButton>();

	public java.util.List<AbstractButton> getButtons() {
		return buttonList;
	}

	public void add(AbstractButton button) {
		buttonList.add(button);
	}

	public void remove(AbstractButton button) {
		buttonList.remove(button);
	}
	private final java.util.List<AbstractLightSensor> lightSensorList = new java.util.LinkedList<AbstractLightSensor>();

	public java.util.List<AbstractLightSensor> getLightSensors() {
		return lightSensorList;
	}

	public void add(AbstractLightSensor lightSensor) {
		lightSensorList.add(lightSensor);
	}

	public void remove(AbstractLightSensor lightSensor) {
		lightSensorList.remove(lightSensor);
	}
	private final java.util.List<AbstractAudioMessenger> audioMessengerList = new java.util.LinkedList<AbstractAudioMessenger>();

	public java.util.List<AbstractAudioMessenger> getAudioMessengers() {
		return audioMessengerList;
	}

	public void add(AbstractAudioMessenger audioMessenger) {
		audioMessengerList.add(audioMessenger);
	}

	public void remove(AbstractAudioMessenger audioMessenger) {
		audioMessengerList.remove(audioMessenger);
	}
	private final java.util.List<AbstractSmokeSensor> smokeSensorList = new java.util.LinkedList<AbstractSmokeSensor>();

	public java.util.List<AbstractSmokeSensor> getSmokeSensors() {
		return smokeSensorList;
	}

	public void add(AbstractSmokeSensor smokeSensor) {
		smokeSensorList.add(smokeSensor);
	}

	public void remove(AbstractSmokeSensor smokeSensor) {
		smokeSensorList.remove(smokeSensor);
	}
	private final java.util.List<AbstractTextToSpeech> textToSpeechList = new java.util.LinkedList<AbstractTextToSpeech>();

	public java.util.List<AbstractTextToSpeech> getTextToSpeechs() {
		return textToSpeechList;
	}

	public void add(AbstractTextToSpeech textToSpeech) {
		textToSpeechList.add(textToSpeech);
	}

	public void remove(AbstractTextToSpeech textToSpeech) {
		textToSpeechList.remove(textToSpeech);
	}
	private final java.util.List<AbstractElectricMeter> electricMeterList = new java.util.LinkedList<AbstractElectricMeter>();

	public java.util.List<AbstractElectricMeter> getElectricMeters() {
		return electricMeterList;
	}

	public void add(AbstractElectricMeter electricMeter) {
		electricMeterList.add(electricMeter);
	}

	public void remove(AbstractElectricMeter electricMeter) {
		electricMeterList.remove(electricMeter);
	}
	private final java.util.List<AbstractScreenInput> screenInputList = new java.util.LinkedList<AbstractScreenInput>();

	public java.util.List<AbstractScreenInput> getScreenInputs() {
		return screenInputList;
	}

	public void add(AbstractScreenInput screenInput) {
		screenInputList.add(screenInput);
	}

	public void remove(AbstractScreenInput screenInput) {
		screenInputList.remove(screenInput);
	}
	private final java.util.List<AbstractIHM> iHMList = new java.util.LinkedList<AbstractIHM>();

	public java.util.List<AbstractIHM> getIHMs() {
		return iHMList;
	}

	public void add(AbstractIHM iHM) {
		iHMList.add(iHM);
	}

	public void remove(AbstractIHM iHM) {
		iHMList.remove(iHM);
	}
	private final java.util.List<AbstractKeyPad> keyPadList = new java.util.LinkedList<AbstractKeyPad>();

	public java.util.List<AbstractKeyPad> getKeyPads() {
		return keyPadList;
	}

	public void add(AbstractKeyPad keyPad) {
		keyPadList.add(keyPad);
	}

	public void remove(AbstractKeyPad keyPad) {
		keyPadList.remove(keyPad);
	}
	private final java.util.List<AbstractOverflowSensor> overflowSensorList = new java.util.LinkedList<AbstractOverflowSensor>();

	public java.util.List<AbstractOverflowSensor> getOverflowSensors() {
		return overflowSensorList;
	}

	public void add(AbstractOverflowSensor overflowSensor) {
		overflowSensorList.add(overflowSensor);
	}

	public void remove(AbstractOverflowSensor overflowSensor) {
		overflowSensorList.remove(overflowSensor);
	}
	private final java.util.List<AbstractLocalStorage> localStorageList = new java.util.LinkedList<AbstractLocalStorage>();

	public java.util.List<AbstractLocalStorage> getLocalStorages() {
		return localStorageList;
	}

	public void add(AbstractLocalStorage localStorage) {
		localStorageList.add(localStorage);
	}

	public void remove(AbstractLocalStorage localStorage) {
		localStorageList.remove(localStorage);
	}
	private final java.util.List<AbstractPrompter> prompterList = new java.util.LinkedList<AbstractPrompter>();

	public java.util.List<AbstractPrompter> getPrompters() {
		return prompterList;
	}

	public void add(AbstractPrompter prompter) {
		prompterList.add(prompter);
	}

	public void remove(AbstractPrompter prompter) {
		prompterList.remove(prompter);
	}
	private final java.util.List<AbstractLight> lightList = new java.util.LinkedList<AbstractLight>();

	public java.util.List<AbstractLight> getLights() {
		return lightList;
	}

	public void add(AbstractLight light) {
		lightList.add(light);
	}

	public void remove(AbstractLight light) {
		lightList.remove(light);
	}
	private final java.util.List<AbstractScreenPrompter> screenPrompterList = new java.util.LinkedList<AbstractScreenPrompter>();

	public java.util.List<AbstractScreenPrompter> getScreenPrompters() {
		return screenPrompterList;
	}

	public void add(AbstractScreenPrompter screenPrompter) {
		screenPrompterList.add(screenPrompter);
	}

	public void remove(AbstractScreenPrompter screenPrompter) {
		screenPrompterList.remove(screenPrompter);
	}
	private final java.util.List<AbstractAppliance> applianceList = new java.util.LinkedList<AbstractAppliance>();

	public java.util.List<AbstractAppliance> getAppliances() {
		return applianceList;
	}

	public void add(AbstractAppliance appliance) {
		applianceList.add(appliance);
	}

	public void remove(AbstractAppliance appliance) {
		applianceList.remove(appliance);
	}
	private final java.util.List<AbstractScreenMessenger> screenMessengerList = new java.util.LinkedList<AbstractScreenMessenger>();

	public java.util.List<AbstractScreenMessenger> getScreenMessengers() {
		return screenMessengerList;
	}

	public void add(AbstractScreenMessenger screenMessenger) {
		screenMessengerList.add(screenMessenger);
	}

	public void remove(AbstractScreenMessenger screenMessenger) {
		screenMessengerList.remove(screenMessenger);
	}
	private final java.util.List<AbstractSetPointConsole> setPointConsoleList = new java.util.LinkedList<AbstractSetPointConsole>();

	public java.util.List<AbstractSetPointConsole> getSetPointConsoles() {
		return setPointConsoleList;
	}

	public void add(AbstractSetPointConsole setPointConsole) {
		setPointConsoleList.add(setPointConsole);
	}

	public void remove(AbstractSetPointConsole setPointConsole) {
		setPointConsoleList.remove(setPointConsole);
	}
	private final java.util.List<AbstractAgenda> agendaList = new java.util.LinkedList<AbstractAgenda>();

	public java.util.List<AbstractAgenda> getAgendas() {
		return agendaList;
	}

	public void add(AbstractAgenda agenda) {
		agendaList.add(agenda);
	}

	public void remove(AbstractAgenda agenda) {
		agendaList.remove(agenda);
	}
	private final java.util.List<AbstractAudioNotifier> audioNotifierList = new java.util.LinkedList<AbstractAudioNotifier>();

	public java.util.List<AbstractAudioNotifier> getAudioNotifiers() {
		return audioNotifierList;
	}

	public void add(AbstractAudioNotifier audioNotifier) {
		audioNotifierList.add(audioNotifier);
	}

	public void remove(AbstractAudioNotifier audioNotifier) {
		audioNotifierList.remove(audioNotifier);
	}
	private final java.util.List<AbstractTvRecorder> tvRecorderList = new java.util.LinkedList<AbstractTvRecorder>();

	public java.util.List<AbstractTvRecorder> getTvRecorders() {
		return tvRecorderList;
	}

	public void add(AbstractTvRecorder tvRecorder) {
		tvRecorderList.add(tvRecorder);
	}

	public void remove(AbstractTvRecorder tvRecorder) {
		tvRecorderList.remove(tvRecorder);
	}
	private final java.util.List<AbstractTvGuide> tvGuideList = new java.util.LinkedList<AbstractTvGuide>();

	public java.util.List<AbstractTvGuide> getTvGuides() {
		return tvGuideList;
	}

	public void add(AbstractTvGuide tvGuide) {
		tvGuideList.add(tvGuide);
	}

	public void remove(AbstractTvGuide tvGuide) {
		tvGuideList.remove(tvGuide);
	}
	private final java.util.List<AbstractPhotoFrame> photoFrameList = new java.util.LinkedList<AbstractPhotoFrame>();

	public java.util.List<AbstractPhotoFrame> getPhotoFrames() {
		return photoFrameList;
	}

	public void add(AbstractPhotoFrame photoFrame) {
		photoFrameList.add(photoFrame);
	}

	public void remove(AbstractPhotoFrame photoFrame) {
		photoFrameList.remove(photoFrame);
	}
	private final java.util.List<AbstractNotifier> notifierList = new java.util.LinkedList<AbstractNotifier>();

	public java.util.List<AbstractNotifier> getNotifiers() {
		return notifierList;
	}

	public void add(AbstractNotifier notifier) {
		notifierList.add(notifier);
	}

	public void remove(AbstractNotifier notifier) {
		notifierList.remove(notifier);
	}
	private final java.util.List<AbstractClock> clockList = new java.util.LinkedList<AbstractClock>();

	public java.util.List<AbstractClock> getClocks() {
		return clockList;
	}

	public void add(AbstractClock clock) {
		clockList.add(clock);
	}

	public void remove(AbstractClock clock) {
		clockList.remove(clock);
	}


	@Override
	public void deployAll() {
  if (lumiereCalculeeInstance == null)
     lumiereCalculeeInstance = getLumiereCalculeeInstance();
  if (regulationIndicatorInstance == null)
     regulationIndicatorInstance = getRegulationIndicatorInstance();

  if (tutorial_phoenixControllerInstance == null)
     tutorial_phoenixControllerInstance = getTutorial_phoenixControllerInstance();


  deployEnablers();
		for (AbstractContactSensor contactSensor : contactSensorList) {
			deploy(contactSensor);
		}
		for (AbstractSmartTv smartTv : smartTvList) {
			deploy(smartTv);
		}
		for (AbstractTemperatureSensor temperatureSensor : temperatureSensorList) {
			deploy(temperatureSensor);
		}
		for (AbstractInput input : inputList) {
			deploy(input);
		}
		for (AbstractTaskManager taskManager : taskManagerList) {
			deploy(taskManager);
		}
		for (AbstractDimmableLight dimmableLight : dimmableLightList) {
			deploy(dimmableLight);
		}
		for (AbstractService service : serviceList) {
			deploy(service);
		}
		for (AbstractSMSSender sMSSender : sMSSenderList) {
			deploy(sMSSender);
		}
		for (AbstractEnergyMeter energyMeter : energyMeterList) {
			deploy(energyMeter);
		}
		for (AbstractTvMessenger tvMessenger : tvMessengerList) {
			deploy(tvMessenger);
		}
		for (AbstractSpeaker speaker : speakerList) {
			deploy(speaker);
		}
		for (AbstractBuiltIn builtIn : builtInList) {
			deploy(builtIn);
		}
		for (AbstractInstantMessenger instantMessenger : instantMessengerList) {
			deploy(instantMessenger);
		}
		for (AbstractPTZVideoCamera pTZVideoCamera : pTZVideoCameraList) {
			deploy(pTZVideoCamera);
		}
		for (AbstractShutter shutter : shutterList) {
			deploy(shutter);
		}
		for (AbstractVisualNotifier visualNotifier : visualNotifierList) {
			deploy(visualNotifier);
		}
		for (AbstractPhysicalDevice physicalDevice : physicalDeviceList) {
			deploy(physicalDevice);
		}
		for (AbstractFan fan : fanList) {
			deploy(fan);
		}
		for (AbstractIdentifier identifier : identifierList) {
			deploy(identifier);
		}
		for (AbstractStorage storage : storageList) {
			deploy(storage);
		}
		for (AbstractTvPrompter tvPrompter : tvPrompterList) {
			deploy(tvPrompter);
		}
		for (AbstractTv tv : tvList) {
			deploy(tv);
		}
		for (AbstractNetworkStorage networkStorage : networkStorageList) {
			deploy(networkStorage);
		}
		for (AbstractGasMeter gasMeter : gasMeterList) {
			deploy(gasMeter);
		}
		for (AbstractServiceTablet serviceTablet : serviceTabletList) {
			deploy(serviceTablet);
		}
		for (AbstractFingerPrintIdentifier fingerPrintIdentifier : fingerPrintIdentifierList) {
			deploy(fingerPrintIdentifier);
		}
		for (AbstractRfidIdentifier rfidIdentifier : rfidIdentifierList) {
			deploy(rfidIdentifier);
		}
		for (AbstractAudioPrompter audioPrompter : audioPrompterList) {
			deploy(audioPrompter);
		}
		for (AbstractDevice device : deviceList) {
			deploy(device);
		}
		for (AbstractVideoCamera videoCamera : videoCameraList) {
			deploy(videoCamera);
		}
		for (AbstractTelephonyGateway telephonyGateway : telephonyGatewayList) {
			deploy(telephonyGateway);
		}
		for (AbstractMobileStorage mobileStorage : mobileStorageList) {
			deploy(mobileStorage);
		}
		for (AbstractHeater heater : heaterList) {
			deploy(heater);
		}
		for (AbstractTimer timer : timerList) {
			deploy(timer);
		}
		for (AbstractRemoteControl remoteControl : remoteControlList) {
			deploy(remoteControl);
		}
		for (AbstractWeatherForecaster weatherForecaster : weatherForecasterList) {
			deploy(weatherForecaster);
		}
		for (AbstractPersonalAddressBook personalAddressBook : personalAddressBookList) {
			deploy(personalAddressBook);
		}
		for (AbstractCOSensor cOSensor : cOSensorList) {
			deploy(cOSensor);
		}
		for (AbstractCamera camera : cameraList) {
			deploy(camera);
		}
		for (AbstractAddressBook addressBook : addressBookList) {
			deploy(addressBook);
		}
		for (AbstractSensor sensor : sensorList) {
			deploy(sensor);
		}
		for (AbstractAlarm alarm : alarmList) {
			deploy(alarm);
		}
		for (AbstractThermostat thermostat : thermostatList) {
			deploy(thermostat);
		}
		for (AbstractBluetoothIdentifier bluetoothIdentifier : bluetoothIdentifierList) {
			deploy(bluetoothIdentifier);
		}
		for (AbstractHomeService homeService : homeServiceList) {
			deploy(homeService);
		}
		for (AbstractAudioInput audioInput : audioInputList) {
			deploy(audioInput);
		}
		for (AbstractDoorLocker doorLocker : doorLockerList) {
			deploy(doorLocker);
		}
		for (AbstractWaterMeter waterMeter : waterMeterList) {
			deploy(waterMeter);
		}
		for (AbstractUserService userService : userServiceList) {
			deploy(userService);
		}
		for (AbstractMicrophone microphone : microphoneList) {
			deploy(microphone);
		}
		for (AbstractApplianceDashBoard applianceDashBoard : applianceDashBoardList) {
			deploy(applianceDashBoard);
		}
		for (AbstractMessenger messenger : messengerList) {
			deploy(messenger);
		}
		for (AbstractMailer mailer : mailerList) {
			deploy(mailer);
		}
		for (AbstractCommunicationService communicationService : communicationServiceList) {
			deploy(communicationService);
		}
		for (AbstractMotionDetector motionDetector : motionDetectorList) {
			deploy(motionDetector);
		}
		for (AbstractButton button : buttonList) {
			deploy(button);
		}
		for (AbstractLightSensor lightSensor : lightSensorList) {
			deploy(lightSensor);
		}
		for (AbstractAudioMessenger audioMessenger : audioMessengerList) {
			deploy(audioMessenger);
		}
		for (AbstractSmokeSensor smokeSensor : smokeSensorList) {
			deploy(smokeSensor);
		}
		for (AbstractTextToSpeech textToSpeech : textToSpeechList) {
			deploy(textToSpeech);
		}
		for (AbstractElectricMeter electricMeter : electricMeterList) {
			deploy(electricMeter);
		}
		for (AbstractScreenInput screenInput : screenInputList) {
			deploy(screenInput);
		}
		for (AbstractIHM iHM : iHMList) {
			deploy(iHM);
		}
		for (AbstractKeyPad keyPad : keyPadList) {
			deploy(keyPad);
		}
		for (AbstractOverflowSensor overflowSensor : overflowSensorList) {
			deploy(overflowSensor);
		}
		for (AbstractLocalStorage localStorage : localStorageList) {
			deploy(localStorage);
		}
		for (AbstractPrompter prompter : prompterList) {
			deploy(prompter);
		}
		for (AbstractLight light : lightList) {
			deploy(light);
		}
		for (AbstractScreenPrompter screenPrompter : screenPrompterList) {
			deploy(screenPrompter);
		}
		for (AbstractAppliance appliance : applianceList) {
			deploy(appliance);
		}
		for (AbstractScreenMessenger screenMessenger : screenMessengerList) {
			deploy(screenMessenger);
		}
		for (AbstractSetPointConsole setPointConsole : setPointConsoleList) {
			deploy(setPointConsole);
		}
		for (AbstractAgenda agenda : agendaList) {
			deploy(agenda);
		}
		for (AbstractAudioNotifier audioNotifier : audioNotifierList) {
			deploy(audioNotifier);
		}
		for (AbstractTvRecorder tvRecorder : tvRecorderList) {
			deploy(tvRecorder);
		}
		for (AbstractTvGuide tvGuide : tvGuideList) {
			deploy(tvGuide);
		}
		for (AbstractPhotoFrame photoFrame : photoFrameList) {
			deploy(photoFrame);
		}
		for (AbstractNotifier notifier : notifierList) {
			deploy(notifier);
		}
		for (AbstractClock clock : clockList) {
			deploy(clock);
		}

  		deploy(lumiereCalculeeInstance);
  		deploy(regulationIndicatorInstance);

  		deploy(tutorial_phoenixControllerInstance);

	}	
	
	@Override
	public void undeployAll() {
  undeployEnablers();
		for (AbstractContactSensor contactSensor : contactSensorList) {
			undeploy(contactSensor);
		}
		for (AbstractSmartTv smartTv : smartTvList) {
			undeploy(smartTv);
		}
		for (AbstractTemperatureSensor temperatureSensor : temperatureSensorList) {
			undeploy(temperatureSensor);
		}
		for (AbstractInput input : inputList) {
			undeploy(input);
		}
		for (AbstractTaskManager taskManager : taskManagerList) {
			undeploy(taskManager);
		}
		for (AbstractDimmableLight dimmableLight : dimmableLightList) {
			undeploy(dimmableLight);
		}
		for (AbstractService service : serviceList) {
			undeploy(service);
		}
		for (AbstractSMSSender sMSSender : sMSSenderList) {
			undeploy(sMSSender);
		}
		for (AbstractEnergyMeter energyMeter : energyMeterList) {
			undeploy(energyMeter);
		}
		for (AbstractTvMessenger tvMessenger : tvMessengerList) {
			undeploy(tvMessenger);
		}
		for (AbstractSpeaker speaker : speakerList) {
			undeploy(speaker);
		}
		for (AbstractBuiltIn builtIn : builtInList) {
			undeploy(builtIn);
		}
		for (AbstractInstantMessenger instantMessenger : instantMessengerList) {
			undeploy(instantMessenger);
		}
		for (AbstractPTZVideoCamera pTZVideoCamera : pTZVideoCameraList) {
			undeploy(pTZVideoCamera);
		}
		for (AbstractShutter shutter : shutterList) {
			undeploy(shutter);
		}
		for (AbstractVisualNotifier visualNotifier : visualNotifierList) {
			undeploy(visualNotifier);
		}
		for (AbstractPhysicalDevice physicalDevice : physicalDeviceList) {
			undeploy(physicalDevice);
		}
		for (AbstractFan fan : fanList) {
			undeploy(fan);
		}
		for (AbstractIdentifier identifier : identifierList) {
			undeploy(identifier);
		}
		for (AbstractStorage storage : storageList) {
			undeploy(storage);
		}
		for (AbstractTvPrompter tvPrompter : tvPrompterList) {
			undeploy(tvPrompter);
		}
		for (AbstractTv tv : tvList) {
			undeploy(tv);
		}
		for (AbstractNetworkStorage networkStorage : networkStorageList) {
			undeploy(networkStorage);
		}
		for (AbstractGasMeter gasMeter : gasMeterList) {
			undeploy(gasMeter);
		}
		for (AbstractServiceTablet serviceTablet : serviceTabletList) {
			undeploy(serviceTablet);
		}
		for (AbstractFingerPrintIdentifier fingerPrintIdentifier : fingerPrintIdentifierList) {
			undeploy(fingerPrintIdentifier);
		}
		for (AbstractRfidIdentifier rfidIdentifier : rfidIdentifierList) {
			undeploy(rfidIdentifier);
		}
		for (AbstractAudioPrompter audioPrompter : audioPrompterList) {
			undeploy(audioPrompter);
		}
		for (AbstractDevice device : deviceList) {
			undeploy(device);
		}
		for (AbstractVideoCamera videoCamera : videoCameraList) {
			undeploy(videoCamera);
		}
		for (AbstractTelephonyGateway telephonyGateway : telephonyGatewayList) {
			undeploy(telephonyGateway);
		}
		for (AbstractMobileStorage mobileStorage : mobileStorageList) {
			undeploy(mobileStorage);
		}
		for (AbstractHeater heater : heaterList) {
			undeploy(heater);
		}
		for (AbstractTimer timer : timerList) {
			undeploy(timer);
		}
		for (AbstractRemoteControl remoteControl : remoteControlList) {
			undeploy(remoteControl);
		}
		for (AbstractWeatherForecaster weatherForecaster : weatherForecasterList) {
			undeploy(weatherForecaster);
		}
		for (AbstractPersonalAddressBook personalAddressBook : personalAddressBookList) {
			undeploy(personalAddressBook);
		}
		for (AbstractCOSensor cOSensor : cOSensorList) {
			undeploy(cOSensor);
		}
		for (AbstractCamera camera : cameraList) {
			undeploy(camera);
		}
		for (AbstractAddressBook addressBook : addressBookList) {
			undeploy(addressBook);
		}
		for (AbstractSensor sensor : sensorList) {
			undeploy(sensor);
		}
		for (AbstractAlarm alarm : alarmList) {
			undeploy(alarm);
		}
		for (AbstractThermostat thermostat : thermostatList) {
			undeploy(thermostat);
		}
		for (AbstractBluetoothIdentifier bluetoothIdentifier : bluetoothIdentifierList) {
			undeploy(bluetoothIdentifier);
		}
		for (AbstractHomeService homeService : homeServiceList) {
			undeploy(homeService);
		}
		for (AbstractAudioInput audioInput : audioInputList) {
			undeploy(audioInput);
		}
		for (AbstractDoorLocker doorLocker : doorLockerList) {
			undeploy(doorLocker);
		}
		for (AbstractWaterMeter waterMeter : waterMeterList) {
			undeploy(waterMeter);
		}
		for (AbstractUserService userService : userServiceList) {
			undeploy(userService);
		}
		for (AbstractMicrophone microphone : microphoneList) {
			undeploy(microphone);
		}
		for (AbstractApplianceDashBoard applianceDashBoard : applianceDashBoardList) {
			undeploy(applianceDashBoard);
		}
		for (AbstractMessenger messenger : messengerList) {
			undeploy(messenger);
		}
		for (AbstractMailer mailer : mailerList) {
			undeploy(mailer);
		}
		for (AbstractCommunicationService communicationService : communicationServiceList) {
			undeploy(communicationService);
		}
		for (AbstractMotionDetector motionDetector : motionDetectorList) {
			undeploy(motionDetector);
		}
		for (AbstractButton button : buttonList) {
			undeploy(button);
		}
		for (AbstractLightSensor lightSensor : lightSensorList) {
			undeploy(lightSensor);
		}
		for (AbstractAudioMessenger audioMessenger : audioMessengerList) {
			undeploy(audioMessenger);
		}
		for (AbstractSmokeSensor smokeSensor : smokeSensorList) {
			undeploy(smokeSensor);
		}
		for (AbstractTextToSpeech textToSpeech : textToSpeechList) {
			undeploy(textToSpeech);
		}
		for (AbstractElectricMeter electricMeter : electricMeterList) {
			undeploy(electricMeter);
		}
		for (AbstractScreenInput screenInput : screenInputList) {
			undeploy(screenInput);
		}
		for (AbstractIHM iHM : iHMList) {
			undeploy(iHM);
		}
		for (AbstractKeyPad keyPad : keyPadList) {
			undeploy(keyPad);
		}
		for (AbstractOverflowSensor overflowSensor : overflowSensorList) {
			undeploy(overflowSensor);
		}
		for (AbstractLocalStorage localStorage : localStorageList) {
			undeploy(localStorage);
		}
		for (AbstractPrompter prompter : prompterList) {
			undeploy(prompter);
		}
		for (AbstractLight light : lightList) {
			undeploy(light);
		}
		for (AbstractScreenPrompter screenPrompter : screenPrompterList) {
			undeploy(screenPrompter);
		}
		for (AbstractAppliance appliance : applianceList) {
			undeploy(appliance);
		}
		for (AbstractScreenMessenger screenMessenger : screenMessengerList) {
			undeploy(screenMessenger);
		}
		for (AbstractSetPointConsole setPointConsole : setPointConsoleList) {
			undeploy(setPointConsole);
		}
		for (AbstractAgenda agenda : agendaList) {
			undeploy(agenda);
		}
		for (AbstractAudioNotifier audioNotifier : audioNotifierList) {
			undeploy(audioNotifier);
		}
		for (AbstractTvRecorder tvRecorder : tvRecorderList) {
			undeploy(tvRecorder);
		}
		for (AbstractTvGuide tvGuide : tvGuideList) {
			undeploy(tvGuide);
		}
		for (AbstractPhotoFrame photoFrame : photoFrameList) {
			undeploy(photoFrame);
		}
		for (AbstractNotifier notifier : notifierList) {
			undeploy(notifier);
		}
		for (AbstractClock clock : clockList) {
			undeploy(clock);
		}

  		undeploy(lumiereCalculeeInstance);
  		undeploy(regulationIndicatorInstance);

  		undeploy(tutorial_phoenixControllerInstance);

	}

  protected abstract AbstractLumiereCalculee getLumiereCalculeeInstance();
  
  public AbstractLumiereCalculee getUniqueLumiereCalculeeInstance() {
		if (lumiereCalculeeInstance == null) {
			lumiereCalculeeInstance = getLumiereCalculeeInstance();
		}
		return lumiereCalculeeInstance;
  }
  protected abstract AbstractRegulationIndicator getRegulationIndicatorInstance();
  
  public AbstractRegulationIndicator getUniqueRegulationIndicatorInstance() {
		if (regulationIndicatorInstance == null) {
			regulationIndicatorInstance = getRegulationIndicatorInstance();
		}
		return regulationIndicatorInstance;
  }

  protected abstract AbstractTutorial_phoenixController getTutorial_phoenixControllerInstance();
  
  public AbstractTutorial_phoenixController getUniqueTutorial_phoenixControllerInstance() {
		if (tutorial_phoenixControllerInstance == null) {
			tutorial_phoenixControllerInstance = getTutorial_phoenixControllerInstance();
		}
		return tutorial_phoenixControllerInstance;
  }
}