package dev.ramanuj.prom_grafana;


import dev.ramanuj.prom_grafana.data.CustomerConstants;
import dev.ramanuj.prom_grafana.data.entity.CustomerRecord;
import dev.ramanuj.prom_grafana.data.repo.CustomerRecordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

@SpringBootTest
public class CustomerRecordDataGeneratorTest {

    @Autowired
    private CustomerRecordRepository customerRecordRepository;

    private final Random random = new Random();
    private final Set<String> usedEmails = new HashSet<>();
    private final Set<String> usedPhoneNumbers = new HashSet<>();

    private String generateUniqueFirstName() {
        return "FirstName" + UUID.randomUUID().toString().substring(0, 8);
    }

    private String generateUniqueLastName() {
        return "LastName" + UUID.randomUUID().toString().substring(0, 8);
    }

    private String generateUniqueEmail() {
        String email;
        do {
            email = "customer" + UUID.randomUUID().toString().substring(0, 8) + "@example.com";
        } while (usedEmails.contains(email));
        usedEmails.add(email);
        return email;
    }

    private String generateUniquePhoneNumber() {
        String phoneNumber;
        do {
            phoneNumber = generatePhoneNumber();
        } while (usedPhoneNumbers.contains(phoneNumber));
        usedPhoneNumbers.add(phoneNumber);
        return phoneNumber;
    }

    private String generatePhoneNumber() {
        return "+1-" + (random.nextInt(900) + 100) + "-" + (random.nextInt(900) + 100) + "-" + (random.nextInt(9000) + 1000);
    }

    private Long generateRandomLong() {
        return Math.abs(random.nextLong() % 1000000000L);
    }

    private Timestamp generateRandomTimestamp() {
        return Timestamp.valueOf(LocalDateTime.now().minusDays(random.nextInt(365 * 40)));
    }

    private BigDecimal generateRandomBigDecimal(int maxWhole, int maxDecimal) {
        double value = random.nextDouble() * Math.pow(10, maxWhole);
        return BigDecimal.valueOf(value).setScale(maxDecimal, BigDecimal.ROUND_HALF_UP);
    }

    @Test
    @Commit
    @Transactional
    public void generateCustomerRecords() {
        for (int i = 0; i < 1000; i++) {
            CustomerRecord customerRecord = new CustomerRecord();
            customerRecord.setAccountCreatedDate(generateRandomTimestamp());
            customerRecord.setAccountLastUpdated(generateRandomTimestamp());
            customerRecord.setAccountLockReason(CustomerConstants.ACCOUNT_LOCK_REASONS[random.nextInt(CustomerConstants.ACCOUNT_LOCK_REASONS.length)]);
            customerRecord.setAccountLocked(random.nextBoolean());
            customerRecord.setAccountManagerId(generateRandomLong());
            customerRecord.setAccountStatus(CustomerConstants.ACCOUNT_STATUSES[random.nextInt(CustomerConstants.ACCOUNT_STATUSES.length)]);
            customerRecord.setAccountUnlockDate(generateRandomTimestamp());
            customerRecord.setAddressLine1("1234 Main St");
            customerRecord.setAddressLine2("Apt " + (random.nextInt(900) + 100));
            customerRecord.setAnnualIncome(generateRandomBigDecimal(7, 2));
            customerRecord.setAverageCancellationValue(generateRandomBigDecimal(5, 2));
            customerRecord.setAverageCartValue(generateRandomBigDecimal(5, 2));
            customerRecord.setAverageDiscountRate(generateRandomBigDecimal(2, 2));
            customerRecord.setAverageOrderTime(generateRandomLong());
            customerRecord.setAverageOrderValue(generateRandomBigDecimal(5, 2));
            customerRecord.setAveragePurchaseFrequency(generateRandomBigDecimal(2, 2));
            customerRecord.setAverageResponseSatisfactionScore(generateRandomBigDecimal(2, 2));
            customerRecord.setAverageResponseTime(generateRandomLong());
            customerRecord.setAverageReturnValue(generateRandomBigDecimal(5, 2));
            customerRecord.setAverageReviewRating(BigDecimal.valueOf(random.nextDouble() * 9).setScale(2, RoundingMode.HALF_UP));
            customerRecord.setAverageShippingTime(generateRandomLong());
            customerRecord.setAverageTicketResolutionTime(generateRandomLong());
            customerRecord.setCartAbandonmentRate(generateRandomBigDecimal(2, 2));
            customerRecord.setCartConversionRate(generateRandomBigDecimal(2, 2));
            customerRecord.setChurnPredictionScore(generateRandomBigDecimal(2, 2));
            customerRecord.setCity(CustomerConstants.CITIES[random.nextInt(CustomerConstants.CITIES.length)]);
            customerRecord.setContractEndDate(generateRandomTimestamp());
            customerRecord.setContractRenewalDate(generateRandomTimestamp());
            customerRecord.setContractStartDate(generateRandomTimestamp());
            customerRecord.setContractValue(generateRandomBigDecimal(6, 2));
            customerRecord.setCountry(CustomerConstants.COUNTRIES[random.nextInt(CustomerConstants.COUNTRIES.length)]);
            customerRecord.setCreditScore(generateRandomBigDecimal(3, 2));
            customerRecord.setCustomerSegment(CustomerConstants.CUSTOMER_SEGMENTS[random.nextInt(CustomerConstants.CUSTOMER_SEGMENTS.length)]);
            customerRecord.setCustomerSince(generateRandomTimestamp());
            customerRecord.setCustomerTier(CustomerConstants.CUSTOMER_TIERS[random.nextInt(CustomerConstants.CUSTOMER_TIERS.length)]);
            customerRecord.setDateOfBirth(generateRandomTimestamp());
            customerRecord.setDeliveryFailureRate(generateRandomBigDecimal(2, 2));
            customerRecord.setDeliverySuccessRate(generateRandomBigDecimal(2, 2));
            customerRecord.setEmail(generateUniqueEmail());
            customerRecord.setEmailVerified(random.nextBoolean());
            customerRecord.setEmergencyContactName("EmergencyContact" + UUID.randomUUID().toString().substring(0, 8));
            customerRecord.setEmergencyContactPhone(generateUniquePhoneNumber());
            customerRecord.setEmergencyContactRelationship("Friend");
            customerRecord.setFailedLoginAttempts(random.nextInt(10));
            customerRecord.setFavoriteProductCategory(CustomerConstants.FAVORITE_PRODUCT_CATEGORIES[random.nextInt(CustomerConstants.FAVORITE_PRODUCT_CATEGORIES.length)]);
            customerRecord.setFirstName(generateUniqueFirstName());
            customerRecord.setFraudAlert(random.nextBoolean());
            customerRecord.setGender(random.nextBoolean() ? "Male" : "Female");
            customerRecord.setHighestOrderValue(generateRandomBigDecimal(5, 2));
            customerRecord.setInAppNotificationsOptIn(random.nextBoolean());
            customerRecord.setLastCartItemAddedDate(generateRandomTimestamp());
            customerRecord.setLastLogin(generateRandomTimestamp());
            customerRecord.setLastLoginIp("192.168.1." + random.nextInt(255));
            customerRecord.setLastName(generateUniqueLastName());
            customerRecord.setLastPasswordChangeDate(generateRandomTimestamp());
            customerRecord.setLastPasswordChangeIp("192.168.1." + random.nextInt(255));
            customerRecord.setLastPurchaseDate(generateRandomTimestamp());
            customerRecord.setLastTicketDate(generateRandomTimestamp());
            customerRecord.setLastUpdatedBySystem(generateRandomTimestamp());
            customerRecord.setLastUpdatedByUser(generateRandomTimestamp());
            customerRecord.setLastWishlistItemAddedDate(generateRandomTimestamp());
            customerRecord.setLifetimeValue(generateRandomBigDecimal(6, 2));
            customerRecord.setLoyaltyPoints(generateRandomLong());
            customerRecord.setLoyaltyProgramId(generateRandomLong());
            customerRecord.setMaritalStatus(CustomerConstants.MARITAL_STATUSES[random.nextInt(CustomerConstants.MARITAL_STATUSES.length)]);
            customerRecord.setMarketingOptIn(random.nextBoolean());
            customerRecord.setMarketingSegment(CustomerConstants.MARKETING_SEGMENTS[random.nextInt(CustomerConstants.MARKETING_SEGMENTS.length)]);
            customerRecord.setMostPurchasedProductCategory(CustomerConstants.FAVORITE_PRODUCT_CATEGORIES[random.nextInt(CustomerConstants.FAVORITE_PRODUCT_CATEGORIES.length)]);
            customerRecord.setNetPromoterScore(generateRandomBigDecimal(2, 2));
            customerRecord.setNewsletterSubscribed(random.nextBoolean());
            customerRecord.setNumberOfCancellations(random.nextInt(10));
            customerRecord.setNumberOfChildren(random.nextInt(5));
            customerRecord.setNumberOfLogins(random.nextInt(50));
            customerRecord.setNumberOfOrders(random.nextInt(100));
            customerRecord.setNumberOfPromoCodesUsed(random.nextInt(10));
            customerRecord.setNumberOfReturns(random.nextInt(10));
            customerRecord.setOccupation(CustomerConstants.OCCUPATIONS[random.nextInt(CustomerConstants.OCCUPATIONS.length)]);
            customerRecord.setPasswordHash(UUID.randomUUID().toString().replace("-", ""));
            customerRecord.setPasswordLastReset(generateRandomTimestamp());
            customerRecord.setPaymentFailureRate(generateRandomBigDecimal(2, 2));
            customerRecord.setPaymentMethod1("Credit Card");
            customerRecord.setPaymentMethod1Details("**** **** **** " + (random.nextInt(9000) + 1000));
            customerRecord.setPaymentMethod2("PayPal");
            customerRecord.setPaymentMethod2Details("customer" + UUID.randomUUID().toString().substring(0, 8) + "@paypal.com");
            customerRecord.setPaymentMethod3("Bank Transfer");
            customerRecord.setPaymentMethod3Details("Bank Account: " + (random.nextInt(900000000) + 100000000));
            customerRecord.setPaymentSuccessRate(generateRandomBigDecimal(2, 2));
            customerRecord.setPhoneNumber(generateUniquePhoneNumber());
            customerRecord.setPhoneVerified(random.nextBoolean());
            customerRecord.setPreferredBillingAddress("1234 Billing St, Apt " + (random.nextInt(900) + 100));
            customerRecord.setPreferredContactMethod(CustomerConstants.PREFERRED_CONTACT_METHODS[random.nextInt(CustomerConstants.PREFERRED_CONTACT_METHODS.length)]);
            customerRecord.setPreferredContactTime("9 AM - 5 PM");
            customerRecord.setPreferredCurrency(CustomerConstants.PREFERRED_CURRENCIES[random.nextInt(CustomerConstants.PREFERRED_CURRENCIES.length)]);
            customerRecord.setPreferredLanguage(CustomerConstants.PREFERRED_LANGUAGES[random.nextInt(CustomerConstants.PREFERRED_LANGUAGES.length)]);
            customerRecord.setPreferredShippingAddress("5678 Shipping St, Apt " + (random.nextInt(900) + 100));
            customerRecord.setProductReviewCount(random.nextInt(100));
            customerRecord.setReferralConversionRate(generateRandomBigDecimal(2, 2));
            customerRecord.setReferredByCustomerId(generateRandomLong());
            customerRecord.setRegisteredIp("192.168.1." + random.nextInt(255));
            customerRecord.setRiskScore(generateRandomBigDecimal(2, 2));
            customerRecord.setSalesRegion(CustomerConstants.STATES[random.nextInt(CustomerConstants.STATES.length)]);
            customerRecord.setSalesRepresentativeId(generateRandomLong());
            customerRecord.setSecurityAnswer1(UUID.randomUUID().toString().substring(0, 8));
            customerRecord.setSecurityAnswer2(UUID.randomUUID().toString().substring(0, 8));
            customerRecord.setSecurityAnswer3(UUID.randomUUID().toString().substring(0, 8));
            customerRecord.setSecurityQuestion1(CustomerConstants.SECURITY_QUESTIONS[random.nextInt(CustomerConstants.SECURITY_QUESTIONS.length)]);
            customerRecord.setSecurityQuestion2(CustomerConstants.SECURITY_QUESTIONS[random.nextInt(CustomerConstants.SECURITY_QUESTIONS.length)]);
            customerRecord.setSecurityQuestion3(CustomerConstants.SECURITY_QUESTIONS[random.nextInt(CustomerConstants.SECURITY_QUESTIONS.length)]);
            customerRecord.setSmsNotificationsOptIn(random.nextBoolean());
            customerRecord.setSocialMediaLoginId(UUID.randomUUID().toString().substring(0, 8));
            customerRecord.setSocialMediaLoginProvider("Provider" + random.nextInt(10));
            customerRecord.setState(CustomerConstants.STATES[random.nextInt(CustomerConstants.STATES.length)]);
            customerRecord.setSubscriptionEndDate(generateRandomTimestamp());
            customerRecord.setSubscriptionPlanId(generateRandomLong());
            customerRecord.setSubscriptionStartDate(generateRandomTimestamp());
            customerRecord.setSubscriptionStatus(CustomerConstants.SUBSCRIPTION_STATUSES[random.nextInt(CustomerConstants.SUBSCRIPTION_STATUSES.length)]);
            customerRecord.setSupportTicketCount(random.nextInt(50));
            customerRecord.setTimezone("UTC" + (random.nextInt(12) - 6));
            customerRecord.setTotalDiscountValue(generateRandomBigDecimal(6, 2));
            customerRecord.setTotalPurchaseValue(generateRandomBigDecimal(6, 2));
            customerRecord.setTotalReferrals(random.nextInt(100));
            customerRecord.setTotalShippingCost(generateRandomBigDecimal(6, 2));
            customerRecord.setTwoFactorEnabled(random.nextBoolean());
            customerRecord.setTwoFactorMethod("SMS");
            customerRecord.setWishListItemCount(random.nextInt(50));
            customerRecord.setZipCode(String.valueOf(random.nextInt(90000) + 10000));

            customerRecordRepository.save(customerRecord);
        }
    }
}
