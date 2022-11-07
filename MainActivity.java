package com.example.co2sensorapp;

import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Clock;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.TextBox;
import com.google.appinventor.components.runtime.VerticalScrollArrangement;

public class MainActivity extends Form implements HandlesEventDispatching {
    private
    VerticalScrollArrangement Main;
    TextBox MyDemonstrationItem;
    Button butt1;
    Clock ResetClock;
    Object img_placeHolder;

    protected void $define() {
        /* this next allows the app to use the full screen.
        In fact, anything makes this work at 100%
        except "Fixed" and the this.Sizing instruction
        being absent in the first place. */
        /* Cur seo isteach. Is cuma cén focal atá ann, níl gá leis */
        this.Sizing("Responsive");

        Main= new VerticalScrollArrangement(this);
        MyDemonstrationItem = new TextBox(Main);
        MyDemonstrationItem.Text("CO2 SENSOR");
        MyDemonstrationItem.TextAlignment(ALIGNMENT_CENTER);
        MyDemonstrationItem.MultiLine(true);
        MyDemonstrationItem.HeightPercent(100);
        MyDemonstrationItem.WidthPercent(100);
        MyDemonstrationItem.FontSize(48);
        MyDemonstrationItem.BackgroundColor(COLOR_CYAN);
        butt1 = new Button(Main);
        butt1.TextColor(Component.COLOR_WHITE);
        ResetClock = new Clock(Main);
        ResetClock.TimerEnabled(false);
        ResetClock.TimerInterval(1000);
        butt1.Text("Continue");
        // now, the events the components can respond to
        EventDispatcher.registerEventForDelegation(this, formName, "Click");
        EventDispatcher.registerEventForDelegation(this, formName, "Timer");
    }
    @Override
        public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params) {
            // finally, here is how the events are responded to
            dbg("dispatchEvent: " + formName + " [" +component.toString() + "] [" + componentName + "] " + eventName);
            if (eventName.equals("Click")) {
                String msg;
                if (component.equals( butt1 )) {
                    MyDemonstrationItem.FontSize(36);
                    MyDemonstrationItem.Text("CO2 MONITOR");
                    MyDemonstrationItem.Text("CO2 (parts per million-ppm)");
                    MyDemonstrationItem.Text("565 ppm");
                    MyDemonstrationItem.Text("Temperature (degrees Celsius)");
                    MyDemonstrationItem.Text("26");
                    butt1.Text("Previous CO2 Readings");
                    butt1.WidthPercent(100);
                    ResetClock.TimerEnabled(true);
                    MyDemonstrationItem.Text("Previous CO2 Readings (per ppm");
                    MyDemonstrationItem.Text("565");
                    MyDemonstrationItem.Text("618");
                    MyDemonstrationItem.Text("594");
                    MyDemonstrationItem.Text("649");
                    MyDemonstrationItem.Text("523");
                    MyDemonstrationItem.Text("606");
                    MyDemonstrationItem.Text("482");
                    return true;
                }
            }
            else if (eventName.equals("Timer")) {
                ResetClock.TimerEnabled(false);
            }
            return false;
        }
        public static void dbg (String debugMsg) {
            System.err.println( "~~~> " + debugMsg + " <~~~\n");
        }
    }
// Here be monsters:
// put unwanted code here, or experimental code awaiting placement