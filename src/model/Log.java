package model;

public class Log {
    private String action;
    private int treeHeight;
    private String rotation = "NONE";

    public Log(String action, int treeHeight, String rotation){
        this.action = action;
        this.treeHeight = treeHeight;
        this.rotation = rotation;
    }

    public Log(String action) {
        this.action = action;
    }

    public Log() {

    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getTreeHeight() {
        return treeHeight;
    }

    public void setTreeHeight(int treeHeight) {
        this.treeHeight = treeHeight;
    }

    public String getRotation() {
        return rotation;
    }

    public void setRotation(String rotation) {
        this.rotation = rotation;
    }

    @Override
    public String toString() {
        String toString;
        if(action != ""){
            toString = action + ";" + treeHeight + ";" + rotation + "\n";
        } else{
            toString = ";;" + rotation + "\n";
        }
        return toString;
    }
}
