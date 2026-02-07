package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.ArrayList;
import java.util.List;

public class Camera {
    private Limelight3A limelight;
    private int goalTag;
    private double xDegrees;
    private double yDegrees;
    private double area;
    private boolean tagFound;
    private ArrayList<Integer> tags;

    public Camera(HardwareMap hardwareMap, int goalTag) {
        //initial setup
        limelight = hardwareMap.get(Limelight3A.class,"limelight");
        limelight.setPollRateHz(100);
        limelight.start();
        limelight.pipelineSwitch(0);

        this.goalTag = goalTag;
    }

    public void poll() {
        LLResult result = limelight.getLatestResult();
        int tagLoc = -1;
        if(result!=null&&result.isValid()) {
            //make list of tags seen and check for the goal tag
            List<LLResultTypes.FiducialResult> tagsSeen = result.getFiducialResults();
            ArrayList<Integer> tags = new ArrayList<>();
            for(int i=0; i<tagsSeen.size(); i++) {
                tags.add(tagsSeen.get(i).getFiducialId());
                if(tagsSeen.get(i).getFiducialId()==goalTag) {
                    tagLoc = i;
                }
            }
            this.tags = tags;

            //update the variables of the goal tag
            if(tagLoc>-1) {
                xDegrees = tagsSeen.get(tagLoc).getTargetXDegrees();
                yDegrees = tagsSeen.get(tagLoc).getTargetYDegrees();
                area = tagsSeen.get(tagLoc).getTargetArea();
                tagFound = true;
            }
            else {
                tagFound = false;
            }
        }
    }

    public double getX() {
        poll();
        return xDegrees;
    }

    public double getY() {
        poll();
        return yDegrees;
    }

    public double getArea() {
        poll();
        return area;
    }

    public boolean tagFound() {
        poll();
        return tagFound;
    }
}
