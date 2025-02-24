import { ref, onUnmounted } from "vue";
import date, { getTime } from "@/utils/date";

export function useDate(format, addtime = 0) {
    const time = ref("");
    const updateTimer = () => {
        time.value = date(format, getTime() + addtime);
    };
    updateTimer();
    const timer = setInterval(updateTimer, 1000);
    onUnmounted(() => {
        clearInterval(timer);
    });
    return time;
}
