package co.kyozen.testsensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SensorTempActivity extends AppCompatActivity implements SensorEventListener{

    private SensorManager sensorManager;
    Sensor sTemperature;
    TextView temperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_temp);

        temperature = findViewById(R.id.temperature);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sTemperature = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if (sTemperature != null) {
            sensorManager.registerListener(SensorTempActivity.this, sTemperature, sensorManager.SENSOR_DELAY_NORMAL);

        } else {
            temperature.setText("Temperature Not Supported");
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        temperature.setText("Temperature: "+event.values[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
