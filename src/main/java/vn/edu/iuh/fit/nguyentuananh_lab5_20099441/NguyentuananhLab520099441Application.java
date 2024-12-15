package vn.edu.iuh.fit.nguyentuananh_lab5_20099441;

import com.neovisionaries.i18n.CountryCode;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.enums.SkillLevel;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.enums.SkillType;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.ids.CandidateSkillId;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.ids.JobSkillId;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.models.*;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.repositories.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;


@SpringBootApplication
public class NguyentuananhLab520099441Application {

    public static void main(String[] args) {
        SpringApplication.run(NguyentuananhLab520099441Application.class, args);
    }
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private ExperienceRepository experienceRepository;
    @Autowired
    private CandidateSkillRepository candidateSkillRepository;
    @Autowired
    private JobSkillRepository jobSkillRepository;

    @Bean
    CommandLineRunner initData() {
        return args -> {
            Random rnd = new Random();
            String[] street = {
            "Nguyen Hue", "Tran Hung Dao", "Hai Ba Trung", "Le Loi", "Ly Thuong Kiet",
            "Vo Thi Sau", "Dien Bien Phu", "Phan Dinh Phung", "Hoang Dieu", "Nguyen Trai",
            "Pham Ngoc Thach", "Le Duan", "Cach Mang Thang Tam", "Nguyen Thi Minh Khai", "Ton Duc Thang",
            "Le Lai", "Mai Thi Luu", "Truong Chinh", "Binh Thoi", "Bach Dang", "Hoa Binh",
            "Ly Tu Trong", "Dai Lo Ham Nghi", "Cong Hoa", "Nguyen Oanh", "To Hien Thanh",
            "Ngo Quyen", "Kinh Duong Vuong", "Hoang Sa", "Tran Quoc Toan", "Xo Viet Nghe Tinh"
        };

        String[] city = {
            "Ho Chi Minh City", "Ha Noi", "Da Nang", "Hue", "Hai Phong",
            "Can Tho", "Quang Ninh", "Binh Duong", "Dong Nai", "Nha Trang",
            "Ha Long", "Quy Nhon", "Vung Tau", "Hai Duong", "Bac Giang",
            "Nam Dinh", "Thai Nguyen", "Thanh Hoa", "Son La", "Nghe An",
            "Bac Ninh", "Vinh", "Phu Quoc", "Lao Cai", "Tuy Hoa",
            "Bac Kan", "Lang Son", "Ca Mau", "Ben Tre", "Kon Tum",
            "Gia Lai", "Ninh Binh"
        };

        String[] number = {
            "09", "08", "07", "03", "02", "04", "05", "06", "01", "10",
            "12", "11", "14", "15", "16", "17", "18", "19", "20", "21",
            "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
        };

        String[] fullName = {
            "Nguyen Van A", "Tran Thi B", "Le Hoang C", "Pham Minh D", "Hoang Ngoc E",
            "Dang Quoc F", "Vu Thi G", "Bui Anh H", "Ngo Bao I", "Do Thuy J",
            "Hoang Thanh K", "Phan Hien L", "Vu Bao M", "Dang Thao N", "Bui Minh O",
            "Nguyen Thi P", "Tran Thi Q", "Le Thanh R", "Pham Thanh S", "Hoang Quang T",
            "Dang Minh U", "Vu Bao V", "Bui Thi W", "Ngo Thi X", "Do Thi Y",
            "Hoang Thi Z", "Phan Thi AA", "Vu Thi BB", "Dang Thi CC", "Bui Thi DD",
            "Nguyen Thi EE", "Tran Thi FF", "Le Thi GG", "Pham Thi HH", "Hoang Thi II",
            "Dang Thi JJ", "Vu Thi KK", "Bui Thi LL", "Ngo Thi MM", "Do Thi NN",
            "Hoang Thi OO", "Phan Thi PP", "Vu Thi QQ", "Dang Thi RR", "Bui Thi SS",
            "Nguyen Thi TT", "Tran Thi UU", "Le Thi VV", "Pham Thi WW", "Hoang Thi XX",
            "Dang Thi YY", "Vu Thi ZZ"
        };


            for (int i = 1; i < 1000; i++) {
                Address address = new Address();
                address.setCity(city[rnd.nextInt(city.length)]);
                address.setStreet(street[rnd.nextInt(street.length)]);
                address.setCountry(CountryCode.VN);
                address.setNumber(rnd.nextInt(1, 1000) + "");
                address.setZipcode(rnd.nextInt(70000, 80000) + "");
                addressRepository.save(address);

                Candidate candidate = new Candidate();
                candidate.setFullName(fullName[rnd.nextInt(fullName.length)]);
                candidate.setDob(LocalDate.of(rnd.nextInt(1980, 2010), rnd.nextInt(1, 12), rnd.nextInt(1, 28)));
                candidate.setEmail("candidate" + i + "@gmail.com");
                candidate.setPhone(number[rnd.nextInt(number.length)] + rnd.nextLong(11111111L, 99999999L));
                candidate.setAddress(address);
                candidateRepository.save(candidate);

                Company company = new Company();
                company.setCompName("Company " + i);
                company.setEmail("company" + i + "@gmail.com");
                company.setPhone(number[rnd.nextInt(number.length)] + rnd.nextLong(11111111L, 99999999L));
                company.setWebUrl("http://company" + i + ".com");
                company.setAbout("About Company " + i);
                company.setJobs(new ArrayList<>()); // Initialize the jobs list
                company.setAddress(address);
                companyRepository.save(company);



                Job job = new Job();
                job.setJobName("Job " + i);
                job.setJobDesc("Job Description " + i);
                job.setCompany(companyRepository.findById((long) rnd.nextInt(1, 1000)).orElse(null));
                jobRepository.save(job);

                // Create and save a Skill
                Skill skill = new Skill();
                skill.setSkillName("Skill " + i);
                skill.setSkillDescription("Skill Description " + i);
                skill.setSkillType(i % 3 == 0 ? SkillType.UNSPECIFIC : i % 3 == 1 ? SkillType.TECHNICAL_SKILL : SkillType.SOFT_SKILL);
                skillRepository.save(skill);

                // Add job to company's job list
                company.getJobs().add(job);
                companyRepository.save(company); // Save company again to update the jobs list

                // Create and save a JobSkill
                JobSkill jobSkill = new JobSkill();
                JobSkillId jobSkillId = new JobSkillId();
                jobSkillId.setJobId(job.getId());
                jobSkillId.setSkillId(skill.getId());
                jobSkill.setId(jobSkillId);
                jobSkill.setJob(job);
                jobSkill.setSkill(skill);
                jobSkill.setSkillLevel(i % 5 == 0 ? SkillLevel.BEGINNER : i % 5 == 1 ? SkillLevel.INTERMEDIATE : i % 5 == 2 ? SkillLevel.ADVANCED : i % 5 == 3 ? SkillLevel.PROFESSIONAL : SkillLevel.MASTER);
                jobSkill.setMoreInfos("More Infos " + i);
                jobSkillRepository.save(jobSkill);

            }
            for (int i = 1; i < 3000; i++) {

            }
            for (int i = 1; i < 100; i++) {
                Experience experience = new Experience();
                experience.setCompany("Company " + i);
                experience.setFromDate(LocalDate.of(rnd.nextInt(1980, 2010), rnd.nextInt(1, 12), rnd.nextInt(1, 28)));
                experience.setToDate(LocalDate.of(rnd.nextInt(2010, 2021), rnd.nextInt(1, 12), rnd.nextInt(1, 28)));
                experience.setRole("Role " + i);
                experience.setWorkDesc("Work Description " + i);
                experience.setCanId(candidateRepository.findById((long) rnd.nextInt(1, 1000)).get().getId());
                experienceRepository.save(experience);
            }
            for (int i = 1; i < 100; i++) {
                Candidate candidate = candidateRepository.findById(rnd.nextLong(1, 1000)).get();
                Skill skill = skillRepository.findById(rnd.nextLong(1, 1000)).get();
                CandidateSkill candidateSkill = new CandidateSkill();
                candidateSkill.setId(new CandidateSkillId());
                candidateSkill.setSkill(skill);
                candidateSkill.setSkillLevel(i % 5 == 0 ? SkillLevel.BEGINNER : i % 5 == 1 ? SkillLevel.INTERMEDIATE : i % 5 == 2 ? SkillLevel.ADVANCED : i % 5 == 3 ? SkillLevel.PROFESSIONAL : SkillLevel.MASTER);
                candidateSkill.setMoreInfos("More Infos " + i);
                candidateSkill.setCandidate(candidate);
                candidateSkillRepository.save(candidateSkill);
            }

        };
    }

}
