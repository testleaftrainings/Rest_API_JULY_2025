package week4.day1.servicenow.pojos;

import java.util.ArrayList;
import java.util.List;

public class CategoryIncident {

    private List<Result> result = new ArrayList<Result>();  

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }   

}