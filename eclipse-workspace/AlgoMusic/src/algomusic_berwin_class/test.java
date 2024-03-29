package algomusic_berwin_class;

/**************
** WARNING - this code automatically generated by Syntona.
** The real source is probably a Syntona patch.
** Do NOT edit this file unless you copy it to another directory and change the name.
** Otherwise it is likely to get clobbered the next time you
** export Java source code from Syntona.
**
** Syntona is available from: http://www.softsynth.com/syntona/
*/

import com.jsyn.ports.UnitOutputPort;
import com.jsyn.unitgen.UnitVoice;
import com.jsyn.unitgen.VariableRateMonoReader;
import com.jsyn.unitgen.Add;
import com.jsyn.unitgen.MultiplyAdd;
import com.jsyn.ports.UnitInputPort;
import com.jsyn.unitgen.Multiply;
import com.jsyn.unitgen.SineOscillator;
import com.softsynth.shared.time.TimeStamp;
import com.jsyn.unitgen.PassThrough;
import com.jsyn.data.SegmentedEnvelope;
import com.jsyn.unitgen.Circuit;

public class Test extends Circuit implements UnitVoice {
    // Declare units and ports.
    PassThrough mFrequencyPassThrough;
    public UnitInputPort frequency;
    PassThrough mAmplitudePassThrough;
    public UnitInputPort amplitude;
    PassThrough mOutputPassThrough;
    public UnitOutputPort output;
    SegmentedEnvelope mS;
    VariableRateMonoReader mMonoRdr;
    Multiply mAtimes;
    Add mAplus;
    Multiply mAtimes2;
    SineOscillator mSineOsc;
    SineOscillator mSineOsc2;
    SineOscillator mSineOsc3;
    Multiply mAtimes22;
    SineOscillator mSineOsc32;
    Add mAplus2;
    Add mAplus3;
    Multiply mAtimes3;
    SineOscillator mSineOsc4;
    Multiply mAtimes222;
    Multiply mAtimes223;
    Add mAplus4;
    MultiplyAdd mAmuladd;

    // Declare inner classes for any child circuits.

    public Test() {
        // Create unit generators.
        add(mFrequencyPassThrough = new PassThrough());
        addPort(frequency = mFrequencyPassThrough.input, "frequency");
        add(mAmplitudePassThrough = new PassThrough());
        addPort(amplitude = mAmplitudePassThrough.input, "amplitude");
        add(mOutputPassThrough = new PassThrough());
        addPort( output = mOutputPassThrough.output, "output");
        double[] mSData = {
            0.10243055555555555, 0.3684210526315789,
            0.0, 0.7719298245614035,
            0.04915654157654875, 0.6578947368421053,
            0.05094819956659316, 0.3991228070175439,
            0.0, 0.7587719298245614,
            0.046104788113615736, 0.39035087719298245,
            0.0568381250952226, 0.7543859649122807,
            0.0, 0.3684210526315789,
            0.05817913520645002, 0.7192982456140351,
            0.08630588134190137, 0.0,
        };
        mS = new SegmentedEnvelope( mSData );
        mS.setSustainBegin( 2 );
        mS.setSustainEnd( 9 );
        add(mMonoRdr = new VariableRateMonoReader());
        add(mAtimes = new Multiply());
        add(mAplus = new Add());
        add(mAtimes2 = new Multiply());
        add(mSineOsc = new SineOscillator());
        add(mSineOsc2 = new SineOscillator());
        add(mSineOsc3 = new SineOscillator());
        add(mAtimes22 = new Multiply());
        add(mSineOsc32 = new SineOscillator());
        add(mAplus2 = new Add());
        add(mAplus3 = new Add());
        add(mAtimes3 = new Multiply());
        add(mSineOsc4 = new SineOscillator());
        add(mAtimes222 = new Multiply());
        add(mAtimes223 = new Multiply());
        add(mAplus4 = new Add());
        add(mAmuladd = new MultiplyAdd());
        // Connect units and ports.
        mFrequencyPassThrough.output.connect(mAtimes.inputA);
        mFrequencyPassThrough.output.connect(mAtimes2.inputA);
        mFrequencyPassThrough.output.connect(mAtimes223.inputA);
        mAmplitudePassThrough.output.connect(mMonoRdr.amplitude);
        mMonoRdr.output.connect(mSineOsc.amplitude);
        mMonoRdr.output.connect(mSineOsc3.amplitude);
        mMonoRdr.output.connect(mAtimes3.inputA);
        mMonoRdr.output.connect(mAtimes22.inputA);
        mMonoRdr.output.connect(mAtimes222.inputA);
        mAtimes.output.connect(mSineOsc2.frequency);
        mAtimes.output.connect(mSineOsc.frequency);
        mAplus.output.connect(mAplus3.inputA);
        mAtimes2.output.connect(mSineOsc3.frequency);
        mAtimes2.output.connect(mSineOsc32.frequency);
        mSineOsc.output.connect(mAplus.inputA);
        mSineOsc2.output.connect(mAplus.inputB);
        mSineOsc3.output.connect(mAplus2.inputA);
        mAtimes22.output.connect(mSineOsc32.amplitude);
        mSineOsc32.output.connect(mAplus2.inputB);
        mAplus2.output.connect(mAplus3.inputB);
        mAplus3.output.connect(mOutputPassThrough.input);
        mAtimes3.output.connect(mSineOsc2.amplitude);
        mAtimes222.output.connect(mSineOsc4.amplitude);
        mAtimes223.output.connect(mSineOsc4.frequency);
        // Setup
        frequency.setup(40.0, 293.6647679174076, 8000.0);
        amplitude.setup(0.0, 0.5, 1.0);
        mMonoRdr.rate.set(1.0);
        mAtimes.inputB.set(0.56);
        mAtimes2.inputB.set(0.92);
        mAtimes22.inputB.set(1.8);
        mAtimes3.inputB.set(0.67);
        mAtimes222.inputB.set(2.67);
        mAtimes223.inputB.set(1.19);
        mAplus4.inputA.set(0.0);
        mAplus4.inputB.set(0.0);
        mAmuladd.inputA.set(0.0);
        mAmuladd.inputB.set(0.0);
        mAmuladd.inputC.set(0.0);
    }

    public void noteOn(double frequency, double amplitude, TimeStamp timeStamp) {
        this.frequency.set(frequency, timeStamp);
        this.amplitude.set(amplitude, timeStamp);
        mMonoRdr.dataQueue.queueOn( mS, timeStamp);
    }

    public void noteOff(TimeStamp timeStamp) {
        mMonoRdr.dataQueue.queueOff( mS, false, timeStamp);
    }
    
    public UnitOutputPort getOutput() {
        return output;
    }
}
