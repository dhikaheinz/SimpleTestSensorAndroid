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

public class SensorLightActivity extends AppCompatActivity implements SensorEventListener{

    private SensorManager sensorManager;
    Sensor sLight;
    TextView light;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_light);

        light = findViewById(R.id.light);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        sLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (sLight != null) {
            sensorManager.registerListener(SensorLightActivity.this, sLight, sensorManager.SENSOR_DELAY_NORMAL);
        } else {
            light.setText("Light Not Supported");
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        light.setText("Light: "+event.values[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
