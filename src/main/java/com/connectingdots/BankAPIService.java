package com.connectingdots;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankAPIService {


    List<BankAPIModel> mcpFintechApis = new ArrayList<>(Arrays.asList(
            new BankAPIModel("/api/v1/users", "Kaustav B.", "GET", "List all users", "2025-05-01", "404 Not Found: No users available"),
            new BankAPIModel("/api/v1/users/{id}", "Kaustav B.", "GET", "Get user by ID", "2025-05-01", "404 Not Found: User not found"),
            new BankAPIModel("/api/v1/users", "Kaustav B.", "POST", "Create a new user", "2025-05-01", "400 Bad Request: Invalid input"),
            new BankAPIModel("/api/v1/users/{id}", "Kaustav B.", "PUT", "Update user profile", "2025-05-01", "404 Not Found: User ID invalid"),
            new BankAPIModel("/api/v1/users/{id}", "Kaustav B.", "DELETE", "Delete a user", "2025-05-01", "403 Forbidden: Cannot delete admin user"),

            new BankAPIModel("/api/v1/accounts", "Sana I.", "GET", "List all accounts", "2025-05-01", "404 Not Found: No accounts exist"),
            new BankAPIModel("/api/v1/accounts/{id}", "Sana I.", "GET", "Get account by ID", "2025-05-01", "404 Not Found: Account not found"),
            new BankAPIModel("/api/v1/accounts", "Sana I.", "POST", "Create a bank account", "2025-05-01", "400 Bad Request: Missing account type"),
            new BankAPIModel("/api/v1/accounts/{id}", "Sana I.", "PUT", "Update account details", "2025-05-01", "404 Not Found: Account not found"),
            new BankAPIModel("/api/v1/accounts/{id}", "Sana I.", "DELETE", "Close a bank account", "2025-05-01", "403 Forbidden: Account has pending transactions"),

            new BankAPIModel("/api/v1/transactions", "Rohan M.", "GET", "List all transactions", "2025-05-01", "500 Internal Server Error"),
            new BankAPIModel("/api/v1/transactions/{id}", "Rohan M.", "GET", "Get transaction details", "2025-05-01", "404 Not Found: Transaction ID invalid"),
            new BankAPIModel("/api/v1/transactions", "Rohan M.", "POST", "Initiate a transaction", "2025-05-01", "400 Bad Request: Insufficient balance"),
            new BankAPIModel("/api/v1/accounts/{id}/transactions", "Rohan M.", "GET", "Get transactions by account", "2025-05-01", "404 Not Found: Account missing"),
            new BankAPIModel("/api/v1/transactions/{id}/cancel", "Rohan M.", "POST", "Cancel a transaction", "2025-05-01", "409 Conflict: Already processed"),

            new BankAPIModel("/api/v1/cards", "Priya D.", "GET", "List all cards", "2025-05-01", "404 Not Found: No cards issued"),
            new BankAPIModel("/api/v1/cards/{id}", "Priya D.", "GET", "Get card by ID", "2025-05-01", "404 Not Found: Card not found"),
            new BankAPIModel("/api/v1/cards", "Priya D.", "POST", "Issue a new card", "2025-05-01", "400 Bad Request: Invalid user ID"),
            new BankAPIModel("/api/v1/cards/{id}/block", "Priya D.", "PATCH", "Block card", "2025-05-01", "409 Conflict: Already blocked"),
            new BankAPIModel("/api/v1/cards/{id}/unblock", "Priya D.", "PATCH", "Unblock card", "2025-05-01", "409 Conflict: Card not blocked"),

            new BankAPIModel("/api/v1/loans", "Arjun K.", "GET", "List all loans", "2025-05-01", "404 Not Found: No loans issued"),
            new BankAPIModel("/api/v1/loans/{id}", "Arjun K.", "GET", "Loan details", "2025-05-01", "404 Not Found: Loan not found"),
            new BankAPIModel("/api/v1/loans", "Arjun K.", "POST", "Apply for a loan", "2025-05-01", "400 Bad Request: Missing fields"),
            new BankAPIModel("/api/v1/loans/{id}/status", "Arjun K.", "GET", "Get loan status", "2025-05-01", "403 Forbidden: Unauthorized"),
            new BankAPIModel("/api/v1/loans/{id}/cancel", "Arjun K.", "POST", "Cancel loan request", "2025-05-01", "409 Conflict: Already approved"),

            new BankAPIModel("/api/v1/auth/login", "Kaustav B.", "POST", "User login", "2025-05-01", "401 Unauthorized: Invalid credentials"),
            new BankAPIModel("/api/v1/auth/logout", "Kaustav B.", "POST", "User logout", "2025-05-01", "401 Unauthorized: Not logged in"),
            new BankAPIModel("/api/v1/auth/register", "Kaustav B.", "POST", "User registration", "2025-05-01", "400 Bad Request: Email exists"),
            new BankAPIModel("/api/v1/auth/token-refresh", "Kaustav B.", "POST", "Refresh access token", "2025-05-01", "400 Bad Request: Token expired"),
            new BankAPIModel("/api/v1/auth/reset-password", "Kaustav B.", "POST", "Reset user password", "2025-05-01", "404 Not Found: Email invalid"),

            new BankAPIModel("/api/v1/wallet", "Rohan M.", "GET", "Get wallet balance", "2025-05-01", "404 Not Found: Wallet not initialized"),
            new BankAPIModel("/api/v1/wallet/load", "Rohan M.", "POST", "Load money to wallet", "2025-05-01", "400 Bad Request: Invalid amount"),
            new BankAPIModel("/api/v1/wallet/transfer", "Rohan M.", "POST", "Transfer from wallet to account", "2025-05-01", "403 Forbidden: Transfer limit exceeded"),
            new BankAPIModel("/api/v1/wallet/history", "Rohan M.", "GET", "Wallet transaction history", "2025-05-01", "404 Not Found: No transactions"),

            new BankAPIModel("/api/v1/settings/profile", "Sana I.", "GET", "Get user profile", "2025-05-01", "403 Forbidden: Not authenticated"),
            new BankAPIModel("/api/v1/settings/profile", "Sana I.", "PUT", "Update user profile", "2025-05-01", "400 Bad Request: Invalid data"),
            new BankAPIModel("/api/v1/settings/password", "Sana I.", "PATCH", "Change password", "2025-05-01", "401 Unauthorized: Old password mismatch"),
            new BankAPIModel("/api/v1/settings/preferences", "Sana I.", "PUT", "Set user preferences", "2025-05-01", "400 Bad Request: Invalid preference"),

            new BankAPIModel("/api/v1/notifications", "Priya D.", "GET", "Fetch all notifications", "2025-05-01", "500 Internal Server Error"),
            new BankAPIModel("/api/v1/notifications/{id}", "Priya D.", "GET", "Fetch notification by ID", "2025-05-01", "404 Not Found: Notification missing"),
            new BankAPIModel("/api/v1/notifications/mark-all-read", "Priya D.", "POST", "Mark all as read", "2025-05-01", "403 Forbidden: Access denied"),

            new BankAPIModel("/api/v1/support/tickets", "Arjun K.", "POST", "Create a support ticket", "2025-05-01", "400 Bad Request: Missing details"),
            new BankAPIModel("/api/v1/support/tickets", "Arjun K.", "GET", "List support tickets", "2025-05-01", "404 Not Found: No tickets"),
            new BankAPIModel("/api/v1/support/tickets/{id}", "Arjun K.", "GET", "Get support ticket", "2025-05-01", "404 Not Found: Ticket not found"),
            new BankAPIModel("/api/v1/support/tickets/{id}/close", "Arjun K.", "PATCH", "Close a support ticket", "2025-05-01", "409 Conflict: Already closed")
    ));

    // Get all apis
    @Tool(description = "Get all api for MCP Fintech Bank")
    public List<BankAPIModel> getAllApi() {
        return mcpFintechApis;
    }

    // Get all apis by the author
    @Tool(description = "Get all api for MCP Fintech Bank by the Author")
    public List<BankAPIModel> getAllApiByAuthor(String author) {
        return mcpFintechApis.stream()
                .filter(bank -> bank.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    // Get all apis by Method Type
    @Tool(description = "Get all api for MCP Fintech Bank by Method Type")
    public List<BankAPIModel> getAllApiByMethod(String type) {
        return mcpFintechApis.stream()
                .filter(bank -> bank.getMethod().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

}
