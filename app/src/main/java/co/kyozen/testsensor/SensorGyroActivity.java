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

public class SensorGyroActivity extends AppCompatActivity implements SensorEventListener{

    private SensorManager sensorManager;
    Sensor sGyroscope;
    TextView xGyroValue, yGyroValue, zGyroValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_gyro);

        xGyroValue = findViewById(R.id.xGyroValue);
        yGyroValue = findViewById(R.id.yGyroValue);
        zGyroValue = findViewById(R.id.zGyroValue);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        sGyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (sGyroscope != null) {
            sensorManager.registerListener(SensorGyroActivity.this, sGyroscope, sensorManager.SENSOR_DELAY_NORMAL);
        } else {
            xGyroValue.setText("Gyroscope Not Supported");
            yGyroValue.setText("Gyroscope Not Supported");
            zGyroValue.setText("Gyroscope Not Supported");
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        xGyroValue.setText("xGyroValue: " + event.values[0]);
        yGyroValue.setText("yGyroValue: " + event.values[1]);
        zGyroValue.setText("zGyroValue: " + event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
