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

public class SensorMagnetActivity extends AppCompatActivity implements SensorEventListener{

    private SensorManager sensorManager;
    Sensor sMagnetometer;
    TextView xMagnoValue, yMagnoValue, zMagnoValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_magnet);

        xMagnoValue = findViewById(R.id.xMagnoValue);
        yMagnoValue = findViewById(R.id.yMagnoValue);
        zMagnoValue = findViewById(R.id.zMagnoValue);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        sMagnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if (sMagnetometer != null) {
            sensorManager.registerListener(SensorMagnetActivity.this, sMagnetometer, sensorManager.SENSOR_DELAY_NORMAL);
        } else {
            xMagnoValue.setText("Magnetometer Not Supported");
            yMagnoValue.setText("Magnetometer Not Supported");
            zMagnoValue.setText("Magnetometer Not Supported");
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        xMagnoValue.setText("xMagnoValue: " + event.values[0]);
        yMagnoValue.setText("yMagnoValue: " + event.values[1]);
        zMagnoValue.setText("zMagnoValue: " + event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
