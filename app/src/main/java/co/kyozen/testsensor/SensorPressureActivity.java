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

public class SensorPressureActivity extends AppCompatActivity implements SensorEventListener{

    private SensorManager sensorManager;
    Sensor sPressure;
    TextView pressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_pressure);

        pressure = findViewById(R.id.pressure);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sPressure = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        if (sPressure != null) {
            sensorManager.registerListener(SensorPressureActivity.this, sPressure, sensorManager.SENSOR_DELAY_NORMAL);
        } else {
            pressure.setText("Pressure Not Supported");
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        pressure.setText("Pressure: "+event.values[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
