package com.smilecare.booking_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // Báo Spring đây là API Controller
@RequestMapping("/api/bookings") // Đặt đường dẫn gốc
public class BookingController {

    @Autowired // Tiêm (Inject) "bộ não" Service vào
    private BookingService bookingService;

    /**
     * API 1: Lấy tất cả
     * (GET http://localhost:8082/api/bookings)
     */
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    /**
     * API 2: Tạo mới
     * (POST http://localhost:8082/api/bookings)
     */
    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody BookingRequestDTO request) {
        try {
            // Gọi logic ở Service
            Booking newBooking = bookingService.createBooking(request);
            // Nếu thành công, trả về 200 OK + booking vừa tạo
            return ResponseEntity.ok(newBooking);
        } catch (RuntimeException e) {
            // Nếu User/Schedule không tìm thấy (lỗi ở Service)
            // Trả về lỗi 400 Bad Request + thông báo lỗi
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}