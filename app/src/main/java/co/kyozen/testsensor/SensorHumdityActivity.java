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

public class SensorHumdityActivity extends AppCompatActivity implements SensorEventListener{

    private SensorManager sensorManager;
    Sensor sHumdity;
    TextView humidity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_humdity);

        humidity = findViewById(R.id.humidity);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sHumdity = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        if (sHumdity != null) {
            sensorManager.registerListener(SensorHumdityActivity.this, sHumdity, sensorManager.SENSOR_DELAY_NORMAL);

        } else {
            humidity.setText("Humdity Not Supported");
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        humidity.setText("Light: "+event.values[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
