package dev.ramanuj.prom_grafana.data;

public class CustomerConstants {

    public static final String[] ACCOUNT_STATUSES = {"Active", "Inactive", "Suspended", "Pending"};
    public static final String[] ACCOUNT_LOCK_REASONS = {"None", "Multiple Failed Logins", "Suspicious Activity"};
    public static final String[] CUSTOMER_SEGMENTS = {"Retail", "Wholesale", "Enterprise"};
    public static final String[] CUSTOMER_TIERS = {"Gold", "Silver", "Bronze"};
    public static final String[] COUNTRIES = {"USA", "Canada", "India", "Germany", "UK"};
    public static final String[] FAVORITE_PRODUCT_CATEGORIES = {"Electronics", "Books", "Fashion", "Home", "Sports"};
    public static final String[] MARKETING_SEGMENTS = {"Newsletter", "Social Media", "Email Campaign", "Loyalty Program"};
    public static final String[] CITIES = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix"};
    public static final String[] STATES = {"NY", "CA", "IL", "TX", "AZ"};
    public static final String[] MARITAL_STATUSES = {"Single", "Married", "Divorced", "Widowed"};
    public static final String[] OCCUPATIONS = {"Engineer", "Doctor", "Teacher", "Artist", "Scientist"};
    public static final String[] PREFERRED_CONTACT_METHODS = {"Email", "Phone", "SMS"};
    public static final String[] PREFERRED_CURRENCIES = {"USD", "CAD", "INR", "EUR", "GBP"};
    public static final String[] PREFERRED_LANGUAGES = {"English", "French", "German", "Spanish", "Hindi"};
    public static final String[] SECURITY_QUESTIONS = {
            "What is your mother's maiden name?",
            "What was the name of your first pet?",
            "What was the name of your first school?"
    };
    public static final String[] SUBSCRIPTION_STATUSES = {"Active", "Expired", "Canceled", "Pending"};
}
