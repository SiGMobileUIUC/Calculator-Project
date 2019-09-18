package com.hinterlong.kevin.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

	private EditText input1;
	private EditText input2;
	private TextView result;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		input1 = findViewById(R.id.input1);
		input2 = findViewById(R.id.input2);
		result = findViewById(R.id.result);
	}

	public void onClick(View button) {
		Double first = parseInput(input1);
		Double second = parseInput(input2);
		if (first == null || second == null) {
			Toast.makeText(this, "Inputs must not be empty", Toast.LENGTH_SHORT).show();
			return;
		}

		switch (button.getId()) {
			case R.id.plus:
				updateResult(first + second);
				break;
			case R.id.minus:
				updateResult(first - second);
				break;
			case R.id.times:
				updateResult(first * second);
				break;
			case R.id.divide:
				if (second == 0.0) {
					Toast.makeText(this, "Cannot divide by 0", Toast.LENGTH_SHORT).show();
				} else {
					updateResult(first / second);
				}
				break;
		}
	}

	public void updateResult(Double out) {
		result.setText(String.format(Locale.getDefault(), "Result is %.3f", out));
	}

	public Double parseInput(EditText input) {
		if (input == null || input.getText() == null || input.getText().toString().isEmpty()) {
			return null;
		}
		return Double.parseDouble(input.getText().toString());
	}
}
