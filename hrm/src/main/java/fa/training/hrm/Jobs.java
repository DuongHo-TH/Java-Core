package fa.training.hrm;

import javax.annotation.processing.Generated;
import javax.persistence.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Generated(value = { "" })
@Table(schema = "dbo", name = "Jobs")
public class Jobs {
    
    @Id
    @Column(name = "job_id", length = 10)
    private String jobId;
    
    @Column(name = "job_title", length = 255, nullable = false, unique = true)
    private String jobTitle;
    
    @Column(name = "min_salary", precision = 11, scale = 2)
    private double minSalary;
    
    @Column(name = "min_salary", precision = 11, scale = 2)
    private double maxSalary;
    
    public Jobs() {
    }
   
    public Jobs(String jobId, String jobTitle, double minSalary,
            double maxSalary) {
        super();
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }
    
}