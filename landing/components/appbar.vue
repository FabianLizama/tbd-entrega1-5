<script setup>
const user = userStore()
const colorMode = useColorMode();

const isDark = computed({
  get () {
    return colorMode.value === 'dark'
  },
  set () {
    colorMode.preference = colorMode.value === 'dark' ? 'light' : 'dark'
  }
})

const tokenCookie = useCookie('token');
const router = useRouter();

function logout() {
    tokenCookie.value = undefined;
    user.$reset();
    router.push('/login');
}

function home() {
    if (tokenCookie.value) {
        if (user.type_user_id === 0) {
            router.push('/coordination');
        } else if (user.type_user_id === 1) {
            router.push('/volunteer');
        }
    }
}

</script>

<template>
    <div class="py-3.5 px-6 shadow md:flex justify-between items-center ">
        <div class="flex items-center justify-between">
            <UButton
                icon="i-heroicons-home-solid"
                color="primary"
                variant="ghost"
                @click="home">
            </UButton>
            <ClientOnly>
                <UButton
                class="ml-2"
                :icon="isDark ? 'i-heroicons-moon-20-solid' : 'i-heroicons-sun-20-solid'"
                color="gray"
                variant="ghost"
                aria-label="Theme"
                @click="isDark = !isDark"
                />
                <template #fallback>
                    <div class="w-8 h-8" />
                </template>
            </ClientOnly>
            <h1 class="text-xl font-bold pl-5">Sistema de Voluntariado</h1>
        </div>
        <div class="flex items-center justify-between">
            <UButton v-if="tokenCookie !== undefined" icon="i-heroicons-user-circle" class="rounded-full" size="xl" variant="ghost" label="Perfil" trailing to="/profile"/>
            <UButton v-if="tokenCookie !== undefined" icon="i-heroicons-arrow-left-on-rectangle" class="rounded-full" size="xl" variant="ghost" trailing @click="logout"/>
        </div>
    </div>
</template>