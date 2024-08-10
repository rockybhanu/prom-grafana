package dev.ramanuj.prom_grafana.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name = "customer_records")
public class CustomerRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp accountCreatedDate;
    private Timestamp accountLastUpdated;
    private String accountLockReason;
    private Boolean accountLocked;
    private Long accountManagerId;
    private String accountStatus;
    private Timestamp accountUnlockDate;
    private String addressLine1;
    private String addressLine2;
    private BigDecimal annualIncome;
    private BigDecimal averageCancellationValue;
    private BigDecimal averageCartValue;
    private BigDecimal averageDiscountRate;
    private Long averageOrderTime;
    private BigDecimal averageOrderValue;
    private BigDecimal averagePurchaseFrequency;
    private BigDecimal averageResponseSatisfactionScore;
    private Long averageResponseTime;
    private BigDecimal averageReturnValue;
    private BigDecimal averageReviewRating;
    private Long averageShippingTime;
    private Long averageTicketResolutionTime;
    private BigDecimal cartAbandonmentRate;
    private BigDecimal cartConversionRate;
    private BigDecimal churnPredictionScore;
    private String city;
    private Timestamp contractEndDate;
    private Timestamp contractRenewalDate;
    private Timestamp contractStartDate;
    private BigDecimal contractValue;
    private String country;
    private BigDecimal creditScore;
    private String customerSegment;
    private Timestamp customerSince;
    private String customerTier;
    private Date dateOfBirth;
    private BigDecimal deliveryFailureRate;
    private BigDecimal deliverySuccessRate;
    private String email;
    private Boolean emailVerified;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private String emergencyContactRelationship;
    private Integer failedLoginAttempts;
    private String favoriteProductCategory;
    private String firstName;
    private Boolean fraudAlert;
    private String gender;
    private BigDecimal highestOrderValue;
    private Boolean inAppNotificationsOptIn;
    private Timestamp lastCartItemAddedDate;
    private Timestamp lastLogin;
    private String lastLoginIp;
    private String lastName;
    private Timestamp lastPasswordChangeDate;
    private String lastPasswordChangeIp;
    private Timestamp lastPurchaseDate;
    private Timestamp lastTicketDate;
    private Timestamp lastUpdatedBySystem;
    private Timestamp lastUpdatedByUser;
    private Timestamp lastWishlistItemAddedDate;
    private BigDecimal lifetimeValue;
    private Long loyaltyPoints;
    private Long loyaltyProgramId;
    private String maritalStatus;
    private Boolean marketingOptIn;
    private String marketingSegment;
    private String mostPurchasedProductCategory;
    private BigDecimal netPromoterScore;
    private Boolean newsletterSubscribed;
    private Integer numberOfCancellations;
    private Integer numberOfChildren;
    private Integer numberOfLogins;
    private Integer numberOfOrders;
    private Integer numberOfPromoCodesUsed;
    private Integer numberOfReturns;
    private String occupation;
    private String passwordHash;
    private Timestamp passwordLastReset;
    private BigDecimal paymentFailureRate;

    @Column(name = "payment_method_1")
    private String paymentMethod1;

    @Column(name = "payment_method_1_details")
    private String paymentMethod1Details;

    @Column(name = "payment_method_2")
    private String paymentMethod2;

    @Column(name = "payment_method_2_details")
    private String paymentMethod2Details;

    @Column(name = "payment_method_3")
    private String paymentMethod3;

    @Column(name = "payment_method_3_details")
    private String paymentMethod3Details;

    private BigDecimal paymentSuccessRate;
    private String phoneNumber;
    private Boolean phoneVerified;
    private String preferredBillingAddress;
    private String preferredContactMethod;
    private String preferredContactTime;
    private String preferredCurrency;
    private String preferredLanguage;
    private String preferredShippingAddress;
    private Integer productReviewCount;
    private BigDecimal referralConversionRate;
    private Long referredByCustomerId;
    private String registeredIp;
    private BigDecimal riskScore;
    private String salesRegion;
    private Long salesRepresentativeId;

    @Column(name = "security_answer_1")
    private String securityAnswer1;

    @Column(name = "security_answer_2")
    private String securityAnswer2;

    @Column(name = "security_answer_3")
    private String securityAnswer3;

    @Column(name = "security_question_1")
    private String securityQuestion1;

    @Column(name = "security_question_2")
    private String securityQuestion2;

    @Column(name = "security_question_3")
    private String securityQuestion3;

    private Boolean smsNotificationsOptIn;
    private String socialMediaLoginId;
    private String socialMediaLoginProvider;
    private String state;
    private Timestamp subscriptionEndDate;
    private Long subscriptionPlanId;
    private Timestamp subscriptionStartDate;
    private String subscriptionStatus;
    private Integer supportTicketCount;
    private String timezone;
    private BigDecimal totalDiscountValue;
    private BigDecimal totalPurchaseValue;
    private Integer totalReferrals;
    private BigDecimal totalShippingCost;
    private Boolean twoFactorEnabled;
    private String twoFactorMethod;
    private Integer wishListItemCount;
    private String zipCode;

}
