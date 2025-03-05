package com.xworkz.chethan_gym.service;

import com.xworkz.chethan_gym.constants.StatusEnum;
import com.xworkz.chethan_gym.dto.*;
import com.xworkz.chethan_gym.entity.*;
import com.xworkz.chethan_gym.repository.GymRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import static java.lang.System.out;

@Service
public class GymServiceImpl implements GymService {

    public GymServiceImpl() {
        out.println("created GymServiceImpl");
    }

    @Autowired
    GymRepositoryImpl gymRepository;

    EnquiryEntity enquiryEntity = new EnquiryEntity();
    RegistrationEntity registrationEntity = new RegistrationEntity();

    TrainersEntity trainersEntity=new TrainersEntity();

    TimeEntity timeEntity = new TimeEntity();

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public boolean validateAdmin(AdminDTO adminDTO) throws NoSuchAlgorithmException {
        AdminEntity adminEntity = gymRepository.getData(adminDTO.getEmail());
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = messageDigest.digest(adminDTO.getPassword().getBytes());
        String encodedHash = Base64.getEncoder().encodeToString(hashedBytes);
        if (adminEntity != null && encodedHash.equals(adminEntity.getPassword())) {
            return true;
        }
        return false;
    }


    @Override
    public boolean validateAndSaveForEnquiry(EnquiryDTO enquiryDTO) {

        if (enquiryDTO != null) {

            enquiryEntity.setName(enquiryDTO.getName());
            enquiryEntity.setArea(enquiryDTO.getArea());
            enquiryEntity.setPh(enquiryDTO.getPh());
            enquiryEntity.setDistance(enquiryDTO.getDistance());
            enquiryEntity.setAge(enquiryDTO.getAge());
            enquiryEntity.setStatus(String.valueOf(StatusEnum.Enquired));
            enquiryEntity.setDescription("This Client's Enquiry has been successfully completed");
            gymRepository.save(enquiryEntity);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Long getCountofPhone(String phone) {
        return gymRepository.getCountOfPhone(phone);
    }


    @Override
    public Long getCountofEmail(String email) {
        return gymRepository.getCountOfEmail(email);
    }

    @Override
    public boolean validateAndSaveForRegistration(RegistrationDTO registrationDTO) {

        if (registrationDTO != null) {
            String password = generatePassword();

            registrationEntity.setName(registrationDTO.getName());
            registrationEntity.setEmail(registrationDTO.getEmail());
            registrationEntity.setPh(registrationDTO.getPh());
            registrationEntity.setPassword(bCryptPasswordEncoder.encode(password));
            registrationEntity.setPackages(registrationDTO.getPackages());
            registrationEntity.setTrainer(registrationDTO.getTrainer());
            registrationEntity.setGymName(registrationDTO.getGymName());
            registrationEntity.setAmount(registrationDTO.getAmount());
            registrationEntity.setDiscount(registrationDTO.getDiscount());
            registrationEntity.setBalance(registrationDTO.getBalance());
            registrationEntity.setInstallment(registrationDTO.getInstallment());
            registrationEntity.setPaidAmount(registrationDTO.getPaidAmount());
            registrationEntity.setUserLoginCount(-1);
            out.println(password);


            boolean saved = gymRepository.saveRegistration(registrationEntity);
            if (saved) {
                return saveEmail(registrationDTO.getEmail(), password);
            }
        }


        return false;
    }

    @Override
    public String generatePassword() {
        int passwordLength = 8;
        String characterPool = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < passwordLength; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }
        return password.toString();
    }


    @Override
    public boolean saveEmail(String email, String password) {

        final String username = "chethan.chiru.rc@gmail.com";
        final String userPassword = "btlw qavi xork qwqd";

        
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail.debug", "true");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, userPassword);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Your password");
            message.setText("your password" + password);
            Transport.send(message);
            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return true;
    }


    @Override
    public List<EnquiryEntity> getAllEnquiries() {
        List<EnquiryEntity> enquiries = gymRepository.getAllEnquiries();
        return enquiries;
    }

    @Override
    public EnquiryEntity updateEnquiry(int enquiryId, String status, String description) {
        enquiryEntity.setEnquiry_id(enquiryId);
        enquiryEntity.setStatus(status);
        enquiryEntity.setDescription(description);

        boolean updated = gymRepository.updateDetailsByenquiryId(enquiryEntity);
        if (updated) {
            System.out.println("Enquiry updated and ViewDetails inserted.");
        } else {
            System.out.println("Failed to update Enquiry or insert ViewDetails.");
        }

        return null;
    }


    @Override
    public boolean updateRegistration(int reg_id,String name, String packages, String trainer, String amount, String paidAmount, String balance) {

        if (reg_id!=0) {
            registrationEntity.setReg_id(reg_id);
            registrationEntity.setName(name);
            registrationEntity.setPackages(packages);
            registrationEntity.setTrainer(trainer);
            registrationEntity.setAmount(amount);
            registrationEntity.setPaidAmount(paidAmount);
            registrationEntity.setBalance(balance);
            gymRepository.updateDetailsByregId(registrationEntity);
            return true;
        }
        return false;
    }

    @Override
    public RegistrationEntity getAllEnquiriesRegistration(String email){

        if (email!=null){
            return gymRepository.getAllEnquiriesRegistration(email);
        }
        return null;
    }

    @Override
    public List<ViewDetailsEntity> getEnquiryById(int enquiryId) {
        if (enquiryId!=0){
            return gymRepository.findEnquiryById(enquiryId);
        }
        return null;
    }

    @Override
    public List<RegUpdateEntity> getPaymentDetailsById(int reg_id){
        if (reg_id!=0){
            return gymRepository.getPaymentDetailsById(reg_id);
        }
        return null;
    }

    @Override
    public boolean validateUserLogin(String email, String password){

       RegistrationEntity registrationEntity1= gymRepository.getAllEnquiriesRegistration(email);
       if (email.equals(registrationEntity1.getEmail())&&bCryptPasswordEncoder.matches(password,registrationEntity1.getPassword())) {
           return true;
       }
        return false;
    }

    @Override
    public boolean updateUserPassword(String email, String newPassword){

        if (email!=null) {
            registrationEntity.setEmail(email);
            registrationEntity.setPassword(bCryptPasswordEncoder.encode(newPassword));
            registrationEntity.setUserLoginCount(0);
            gymRepository.updateUserPassword(registrationEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUserProfile(int reg_id , String name , String email , String ph , String age , String weight , String height , String plan , String filePath) {

        if (reg_id!=0){
            registrationEntity.setReg_id(reg_id);
            registrationEntity.setName(name);
            registrationEntity.setEmail(email);
            registrationEntity.setPh(ph);
            registrationEntity.setAge(age);
            registrationEntity.setWeight(weight);
            registrationEntity.setHeight(height);
            registrationEntity.setPlan(plan);
            gymRepository.updateUserProfile(registrationEntity , filePath);
            return true;
        }
        return false;
    }

    @Override
    public boolean onTrainers(TrainerDTO trainerDTO)  {
        if (trainerDTO!=null){
            trainersEntity.setName(trainerDTO.getName());
            trainersEntity.setPh(trainerDTO.getPh());
            gymRepository.saveTrainers(trainersEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean onTime(TimeDTO timeDTO)  {
        if (timeDTO!=null){
            timeEntity.setStartTime(timeDTO.getStartTime());
            timeEntity.setEndTime(timeDTO.getEndTime());
            timeEntity.setDuration(timeDTO.getDuration());
            gymRepository.saveTime(timeEntity);
            return true;
        }
        return false;
    }

    @Override
    public List<TrainersEntity> getAllTrainers() {
        List<TrainersEntity> trainers = gymRepository.getAllTrainers();
        return trainers;
    }

    @Override
    public List<TimeEntity> getSlots() {
        List<TimeEntity> slots = gymRepository.getSlots();
        return slots;
    }

    @Override
    public boolean updateSlotsForTrainers(String name, String slots){

        if (name!=null) {
            trainersEntity.setName(name);
            trainersEntity.setSlots(slots);
            gymRepository.updateSlotsForTrainers(trainersEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeSlots(String name){

        if (name!=null) {
            trainersEntity.setName(name);
            trainersEntity.setSlots(null);
            gymRepository.updateSlotsForTrainers(trainersEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateSlotsForClients(String clientName, String trainerName, String slots){

        if (clientName!=null) {
            registrationEntity.setName(clientName);
            registrationEntity.setSlots(slots);
            registrationEntity.setTrainerName(trainerName);
            gymRepository.updateSlotsForClients(registrationEntity);
            return true;
        }
        return false;
    }

    @Override
    public List<RegistrationEntity> getAllClientsForTrainer(String trainerName) {
        List<RegistrationEntity> clients = gymRepository.getClientsOfTrainer(trainerName);
        return clients;
    }

    @Override
    public boolean deleteTrainer(String trainerName) {
        boolean deleted =gymRepository.deleteTrainer(trainerName);
        if (deleted){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateDAWForClients(String clientName, String dietPlan, String workoutPlan){

        if (clientName!=null) {
            registrationEntity.setName(clientName);
           if (dietPlan.equals("VEG_WEIGHT_GAIN")){
               registrationEntity.setDietPlan("Breakfast: Oats with whole milk, almonds, banana, peanut butter toast\\n\" +\n" +
                       "        \"Mid-Morning Snack: Greek yogurt with honey and nuts, dates\\n\" +\n" +
                       "        \"Lunch: Paneer curry, brown rice, mixed vegetable sabzi, dal, avocado salad\\n\" +\n" +
                       "        \"Afternoon Snack: Protein smoothie (banana, peanut butter, oats, milk, whey protein)\\n\" +\n" +
                       "        \"Dinner: Quinoa with chickpeas, sautéed vegetables, olive oil dressing\\n\" +\n" +
                       "        \"Post-Dinner: Cottage cheese (paneer), handful of nuts, dark chocolate");
               registrationEntity.setWorkoutPlan("Day 1: Strength Training (Squats, Deadlifts, Bench Press, Shoulder Press)\\n\" +\n" +
                       "        \"Day 2: Cardio + Core (Cycling, Planks, Russian Twists, Hanging Leg Raises)\\n\" +\n" +
                       "        \"Day 3: Upper Body (Pull-ups, Dumbbell Rows, Bicep Curls, Tricep Dips)\\n\" +\n" +
                       "        \"Day 4: Rest or Active Recovery (Yoga, Stretching)\\n\" +\n" +
                       "        \"Day 5: Lower Body (Lunges, Leg Press, Calf Raises, Hamstring Curls)\\n\" +\n" +
                       "        \"Day 6: Full Body Workout (Burpees, Kettlebell Swings, Deadlifts, Squat Jumps)\\n\" +\n" +
                       "        \"Day 7: Rest");
           }
           if (dietPlan.equals("VEG_WEIGHT_LOSS")){
               registrationEntity.setDietPlan("Breakfast: Oats with chia seeds, flaxseeds, and almond milk\\n\" +\n" +
                       "        \"Mid-Morning Snack: Green smoothie (spinach, cucumber, chia seeds, lemon)\\n\" +\n" +
                       "        \"Lunch: Dal, quinoa, mixed vegetable stir-fry, cucumber salad\\n\" +\n" +
                       "        \"Afternoon Snack: Handful of almonds, green tea\\n\" +\n" +
                       "        \"Dinner: Grilled tofu or paneer, sautéed vegetables, lemon water\\n\" +\n" +
                       "        \"Post-Dinner: Greek yogurt with berries");
               registrationEntity.setWorkoutPlan("Day 1: HIIT (Jump Squats, Mountain Climbers, Burpees, Plank Holds)\\n\" +\n" +
                       "        \"Day 2: Cardio (Running, Cycling, Jump Rope)\\n\" +\n" +
                       "        \"Day 3: Strength Training (Squats, Deadlifts, Dumbbell Press, Shoulder Press)\\n\" +\n" +
                       "        \"Day 4: Core & Flexibility (Yoga, Pilates, Ab Workouts)\\n\" +\n" +
                       "        \"Day 5: Full Body Circuit (Push-ups, Kettlebell Swings, Box Jumps, Sled Pushes)\\n\" +\n" +
                       "        \"Day 6: Cardio + Endurance (Rowing, Stair Climbing, Sprint Intervals)\\n\" +\n" +
                       "        \"Day 7: Rest or Active Recovery");
           }
           if (dietPlan.equals("NON_VEG_WEIGHT_GAIN")){
               registrationEntity.setDietPlan("Breakfast: Scrambled eggs with whole wheat toast, peanut butter, milk\\n\" +\n" +
                       "        \"Mid-Morning Snack: Boiled eggs, nuts (almonds, walnuts), Greek yogurt\\n\" +\n" +
                       "        \"Lunch: Grilled chicken breast, brown rice, mixed greens, olive oil dressing\\n\" +\n" +
                       "        \"Afternoon Snack: Protein shake (banana, oats, whey protein, peanut butter)\\n\" +\n" +
                       "        \"Dinner: Grilled salmon, mashed sweet potatoes, sautéed spinach\\n\" +\n" +
                       "        \"Post-Dinner: Cottage cheese or boiled eggs, handful of nuts");
               registrationEntity.setWorkoutPlan("Day 1: Strength Training (Squats, Deadlifts, Bench Press, Shoulder Press)\\n\" +\n" +
                       "        \"Day 2: Cardio + Core (Cycling, Planks, Russian Twists, Hanging Leg Raises)\\n\" +\n" +
                       "        \"Day 3: Upper Body (Pull-ups, Dumbbell Rows, Bicep Curls, Tricep Dips)\\n\" +\n" +
                       "        \"Day 4: Rest or Active Recovery (Yoga, Stretching)\\n\" +\n" +
                       "        \"Day 5: Lower Body (Lunges, Leg Press, Calf Raises, Hamstring Curls)\\n\" +\n" +
                       "        \"Day 6: Full Body Workout (Burpees, Kettlebell Swings, Deadlifts, Squat Jumps)\\n\" +\n" +
                       "        \"Day 7: Rest");
           }
           if (dietPlan.equals("NON_VEG_WEIGHT_LOSS")){
               registrationEntity.setDietPlan("Breakfast: Boiled eggs with avocado toast, black coffee\\n\" +\n" +
                       "        \"Mid-Morning Snack: Green smoothie (spinach, ginger, chia seeds)\\n\" +\n" +
                       "        \"Lunch: Grilled chicken or fish, quinoa, steamed vegetables\\n\" +\n" +
                       "        \"Afternoon Snack: Handful of almonds, green tea\\n\" +\n" +
                       "        \"Dinner: Grilled fish or boiled eggs, sautéed vegetables, lemon water\\n\" +\n" +
                       "        \"Post-Dinner: Greek yogurt with nuts");
               registrationEntity.setWorkoutPlan("Day 1: HIIT (Jump Squats, Mountain Climbers, Burpees, Plank Holds)\\n\" +\n" +
                       "        \"Day 2: Cardio (Running, Cycling, Jump Rope)\\n\" +\n" +
                       "        \"Day 3: Strength Training (Squats, Deadlifts, Dumbbell Press, Shoulder Press)\\n\" +\n" +
                       "        \"Day 4: Core & Flexibility (Yoga, Pilates, Ab Workouts)\\n\" +\n" +
                       "        \"Day 5: Full Body Circuit (Push-ups, Kettlebell Swings, Box Jumps, Sled Pushes)\\n\" +\n" +
                       "        \"Day 6: Cardio + Endurance (Rowing, Stair Climbing, Sprint Intervals)\\n\" +\n" +
                       "        \"Day 7: Rest or Active Recovery");

           }
           gymRepository.updateDAWForClients(registrationEntity);
           return true;
        }
        return false;
    }

}



